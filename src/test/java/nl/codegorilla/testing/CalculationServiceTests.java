package nl.codegorilla.testing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculationServiceTests {
    @Test
    void shouldAdd() {
        CalculationService calcService = new CalculationService();
        int actualResult = calcService.add(1, 2);
        int expectedResult = 3;
        assertEquals(expectedResult, actualResult);
    }
}
