package de.bmw.aw.storagebinservice.data;

import de.bmw.aw.storagebinservice.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
}
