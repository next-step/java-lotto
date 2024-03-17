package step1;

import step1.domain.CalculatorService;
import step1.dto.CalculateRequestDto;
import step1.view.InputView;
import step1.view.ResultView;

public class CalculatorController {

    private final CalculatorService calculatorService = new CalculatorService();

    public void calculateStart() {
        String values = InputView.inputCalculateValues();
        CalculateRequestDto requestDto = new CalculateRequestDto(values);
        int result = calculatorService.calculateValues(requestDto);
        ResultView.displayResult(result);
    }
}
