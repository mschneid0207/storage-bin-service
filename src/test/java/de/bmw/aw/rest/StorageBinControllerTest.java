package de.bmw.aw.rest;

import de.bmw.aw.business.StorageBinService;
import de.bmw.aw.exception.NotFoundEntityException;
import de.bmw.aw.model.StorageBin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.ws.rs.core.MediaType;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = StorageBinController.class)
public class StorageBinControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StorageBinService storageBinServiceMock;

    private StorageBin storageBinService =
            StorageBin.builder()
                    .id(1L)
                    .corridor(1)
                    .rack(10)
                    .level(2)
                    .section(11).build();

    @Test
    public void retrieveStorageBin() throws Exception {
        when(storageBinServiceMock.findStorageBinById(Mockito.anyLong())).thenReturn(storageBinService);

        RequestBuilder request =
                MockMvcRequestBuilders
                        .get("/storage_bins/1")
                        .accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{id:1, corridor:1, rack:10, level:2}"));
    }

    @Test
    public void deleteStorageBin() throws Exception {
        MockHttpServletRequestBuilder request =
                MockMvcRequestBuilders
                        .delete("/storage_bins/{id}", 1)
                        .accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(request)
                .andExpect(status().isOk());
    }

    @Test
    public void deleteStorageBinNotFoundEntityException() throws Exception {
        when(storageBinServiceMock.findStorageBinById(anyLong())).thenThrow(NotFoundEntityException.class);
        MockHttpServletRequestBuilder request =
                MockMvcRequestBuilders
                        .delete("/storage_bins/{id}", 1)
                        .accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(request)
                .andExpect(status().isNotFound());
    }


}
