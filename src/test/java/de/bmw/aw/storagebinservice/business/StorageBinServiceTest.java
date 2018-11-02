package de.bmw.aw.storagebinservice.business;

import de.bmw.aw.storagebinservice.data.StorageBinRepository;
import de.bmw.aw.storagebinservice.exception.NotFoundEntityException;
import de.bmw.aw.storagebinservice.model.StorageBin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StorageBinServiceTest {

    @InjectMocks
    private StorageBinService sut;

    @Mock
    private StorageBinRepository repositoryMock;

    @Test
    public void findStorageBinById() {
        StorageBin expectedStorageBin = StorageBin.builder().id(1000L).corridor(1).rack(1).level(1).build();
        when(repositoryMock.findById(1000L)).thenReturn(Optional.of(expectedStorageBin));
        StorageBin storageBin = sut.findStorageBinById(1000L);
        assertNotNull(storageBin);
        assertEquals(1, (int) storageBin.getCorridor());
    }

    @Test(expected = NotFoundEntityException.class)
    public void findStorageBinByIdNotFoundEntityException() {
        when(repositoryMock.findById(1000L)).thenReturn(Optional.empty());
        sut.findStorageBinById(1000L);
    }


}