package com.mrongo.inventoryService.service;

import com.mrongo.inventoryService.dto.InventoryResponse;
import com.mrongo.inventoryService.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {
    @Autowired
    private final InventoryRepository inventoryRepository;
//    @Transactional(readOnly = true)
//    public boolean isInStock(List<String> skuCode){
//        return inventoryRepository.findBySkuCodeIn(skuCode).isPresent();
//    }

    @Transactional(readOnly = true)
//    @SneakyThrows
    public List<InventoryResponse> isInStock(List<String> skuCode){
//        log.info("Wait has started");
//        Thread.sleep(10000);
//        log.info("Wait has ended");
        return inventoryRepository.findBySkuCodeIn(skuCode).stream()
                .map(inventory ->
                    InventoryResponse.builder()
                            .skuCode(inventory.getSkuCode())
                            .isInStock(inventory.getQuantity() > 0)
                            .build()
                )
                .toList();
    }
}
