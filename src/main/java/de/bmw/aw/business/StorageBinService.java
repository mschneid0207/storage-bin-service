package de.bmw.aw.business;

import de.bmw.aw.data.StorageBinRepository;
import de.bmw.aw.data.WarehouseRepository;
import de.bmw.aw.exception.NotFoundEntityException;
import de.bmw.aw.model.StorageBin;
import de.bmw.aw.model.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StorageBinService {

	@Autowired
    private StorageBinRepository storageBinRepository;

    @Autowired
    private WarehouseRepository warehouseRepository;

	public StorageBin findStorageBinById(long id) {
        StorageBin storageLocation = storageBinRepository.findById(id)
                .orElseThrow(() -> new NotFoundEntityException("storage location with id " + id + " was not found!"));
		return storageLocation;
	}
	
	public StorageBin saveStorageBin(StorageBin storageBin) {
        return storageBinRepository.save(storageBin);
	}
	
	public void deleteStorageBin(long id) {
        storageBinRepository.deleteById(id);
    }

    public Warehouse findSWarehouseById(long id) {
        Warehouse warehouse = warehouseRepository.findById(id)
                .orElseThrow(() -> new NotFoundEntityException("warehouse with id " + id + " was not found!"));
        return warehouse;
    }

}
