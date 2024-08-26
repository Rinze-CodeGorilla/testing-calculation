package nl.codegorilla.testing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {

    @Autowired CalculationService calculationService;

    @PostMapping("/calculate")
    public String calculate(int first, int second, String operator, Model model) {
        int result = switch(operator) {
            case "+" -> calculationService.add(first, second);
            case "-" -> calculationService.subtract(first, second);
            default -> throw new IllegalStateException("Unexpected value: " + operator);
        };
        model.addAttribute("result", result);
        return "result";
    }
}
