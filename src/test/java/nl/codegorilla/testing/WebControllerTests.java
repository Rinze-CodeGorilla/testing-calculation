package nl.codegorilla.testing;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
public class WebControllerTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CalculationService calculationService;

    @Test
    void shouldAdd() throws Exception {
        when(calculationService.add(anyInt(), anyInt())).thenReturn(1);
        verify(calculationService, atMostOnce()).add(3, 2);
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/calculate")
                        .formField("first", "3")
                        .formField("second", "2")
                        .formField("operator", "+")
                )
                .andExpectAll(
                        status().isOk(),
                        content().string(containsString("<p>1</p>")),
                        content().string(containsString("antwoord"))
                );
    }
}
