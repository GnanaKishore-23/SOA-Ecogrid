package com.ecogrid.prosumerservice;

import com.ecogrid.prosumerservice.controller.ProsumerController;
import com.ecogrid.prosumerservice.model.ProsumerProfile;
import com.ecogrid.prosumerservice.repository.ProsumerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProsumerController.class)
public class ProsumerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProsumerRepository repository;

    @Test
    public void testGetAllProsumers() throws Exception {
        ProsumerProfile profile = new ProsumerProfile("Solar Alpha", "SOLAR", 50.0, "ZONE-1");
        profile.setId(1L);

        List<ProsumerProfile> profiles = Arrays.asList(profile);
        Mockito.when(repository.findAll()).thenReturn(profiles);

        mockMvc.perform(get("/api/prosumers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Solar Alpha"))
                .andExpect(jsonPath("$[0].surplusCapacityKw").value(50.0));
    }

    @Test
    public void testCreateProsumer() throws Exception {
        ProsumerProfile profile = new ProsumerProfile("Wind Beta", "WIND", 30.0, "ZONE-2");
        profile.setId(2L);

        Mockito.when(repository.save(Mockito.any(ProsumerProfile.class))).thenReturn(profile);

        String jsonPayload = """
                {
                    "name": "Wind Beta",
                    "energyType": "WIND",
                    "surplusCapacityKw": 30.0,
                    "locationGridZone": "ZONE-2"
                }
                """;

        mockMvc.perform(post("/api/prosumers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.name").value("Wind Beta"));
    }
}