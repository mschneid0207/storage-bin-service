package de.bmw.aw.rest;

import de.bmw.aw.business.StorageBinService;
import de.bmw.aw.exception.NotFoundEntityException;
import de.bmw.aw.model.StorageBin;
import de.bmw.aw.model.Warehouse;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@Slf4j
public class StorageBinController {

	@Autowired
	private StorageBinService service;

	@GetMapping("/storage_bins/{id}")
	@ApiOperation(value = "retrieves storage bin by id")
	public StorageBin retrieveStorageBin(@PathVariable int id) {
		StorageBin storageBin = service.findStorageBinById(id);
		return storageBin;
	}

	@PostMapping("/storage_bins")
	@ApiOperation(value = "creates new storage bin")
	public ResponseEntity createStorageBin(@RequestBody StorageBin storageBin) {
		StorageBin savedStorageBin = service.saveStorageBin(storageBin);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedStorageBin.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}

	@PutMapping("/storage_bins/{id}")
	@ApiOperation(value = "updates storage bin by id")
	public ResponseEntity updateStorageBin(@PathVariable int id, @RequestBody StorageBin storageBin) {
		StorageBin currentStorageBin = service.findStorageBinById(id);
		storageBin.setId(currentStorageBin.getId());
		StorageBin updatedStorageBin = service.saveStorageBin(storageBin);
		return new ResponseEntity<>(updatedStorageBin, HttpStatus.OK);

	}
	
	@DeleteMapping("/storage_bins/{id}")
	@ApiOperation(value = "deletes storage bin by id")
	public void deleteStorageBin(@PathVariable int id) {
		try {
		service.findStorageBinById(id);
		service.deleteStorageBin(id);
		} catch (NotFoundEntityException e) {
			throw e;
		}
	}

	@GetMapping("/free_storage_bin")
	@ApiOperation(value = "returns free storage bin")
	public StorageBin findFreeStorageBin() {
		return service.findStorageBinById(1000L);
	}

	@GetMapping("/warehouse/{id}")
	@ApiOperation(value = "retrieves warehouse by id")
	public Warehouse retrieveWarehouse(@PathVariable int id) {
		Warehouse warehouse = service.findSWarehouseById(id);
		return warehouse;
	}

}
