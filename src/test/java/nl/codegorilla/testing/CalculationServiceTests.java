package nl.codegorilla.testing;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class CalculationServiceTests {
    @BeforeEach
    void setUp() {
        System.out.println("@BeforeEach");
    }

    @BeforeAll
    static void setUpBeforeClass() {
        System.out.println("@BeforeAll");
        calcService = new CalculationService();
    }

        @AfterEach
        void after() {
            System.out.println("@AfterEach");
        }
    static CalculationService calcService;

    @Test
    void shouldAdd() {
        System.out.println("shouldAdd");
        int actualResult = calcService.add(1, 2);
        int expectedResult = 3;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void shouldSubtract() {
        System.out.println("shouldSubtract");
        int actualResult = calcService.subtract(1, 2);
        int expectedResult = -1;
        assertEquals(expectedResult, actualResult);
    }
}
