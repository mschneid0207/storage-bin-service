package de.bmw.aw.storagebinservice.data;

import de.bmw.aw.storagebinservice.model.StorageBin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageBinRepository extends JpaRepository<StorageBin, Long> {

}
