package step1;

import step1.dto.CalculateRequestDto;
import step1.view.InputView;

public class CalculatorController {

    public void calculateStart() {
        String values = InputView.inputCalculateValues();
        CalculateRequestDto requestDto = new CalculateRequestDto(values);
    }
}
