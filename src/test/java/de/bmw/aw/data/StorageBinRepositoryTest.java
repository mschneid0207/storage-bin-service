package de.bmw.aw.data;

import de.bmw.aw.model.StorageBin;
import de.bmw.aw.model.Warehouse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StorageBinRepositoryTest {

    @Autowired
    private StorageBinRepository sut;

    @Test
    public void findStorageBindById() {
        Optional<StorageBin> storageBin = sut.findById(1000L);
        assertTrue(storageBin.isPresent());
        assertEquals(15, (int) storageBin.get().getCorridor());
        Warehouse warehouse = storageBin.get().getWarehouse();
        assertEquals(100L, (long) warehouse.getId());
    }

    @Test
    public void findStorageBindByIdNotFound() {
        Optional<StorageBin> storageBin = sut.findById(2000L);
        assertFalse(storageBin.isPresent());
    }

    @Test
    public void findAll() {
        List<StorageBin> storageBins = sut.findAll();
        assertEquals(3, storageBins.size());
    }
}