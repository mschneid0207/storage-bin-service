package de.bmw.aw.data;

import de.bmw.aw.model.StorageBin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageBinRepository extends JpaRepository<StorageBin, Long> {

}
