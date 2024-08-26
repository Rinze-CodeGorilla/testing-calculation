package nl.codegorilla.testing;

import org.springframework.stereotype.Service;

@Service
public class CalculationService {
    int add(int a, int b) {
        return a + b;
    }

    int subtract(int a, int b) {
        return a - b;
    }
}
