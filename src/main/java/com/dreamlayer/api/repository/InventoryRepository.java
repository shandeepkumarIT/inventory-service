package com.dreamlayer.api.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.dreamlayer.api.modal.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

	List<Inventory> findBySkuCodeIn(List<String> skuCode);
}
