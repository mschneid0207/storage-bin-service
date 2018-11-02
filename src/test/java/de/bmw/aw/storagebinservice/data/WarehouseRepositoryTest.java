package de.bmw.aw.storagebinservice.data;

import de.bmw.aw.storagebinservice.model.Warehouse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringRunner.class)
@DataJpaTest
public class WarehouseRepositoryTest {

    @Autowired
    private WarehouseRepository sut;

    @Test
    public void findWarehouseById() {
        Optional<Warehouse> warehouse = sut.findById(100L);
        assertNotNull(warehouse.isPresent());
        assertEquals("Dingolfing", warehouse.get().getLocation());
        assertEquals(3, warehouse.get().getStorageBins().size());
    }

}