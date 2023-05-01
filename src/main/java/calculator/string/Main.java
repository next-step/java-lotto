package calculator.string;

import calculator.string.domain.CalculatorSign;
import calculator.string.domain.Number;
import calculator.string.service.CalculateService;
import calculator.string.view.InputView;
import calculator.string.view.OutputView;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        CalculateService calculateService = new CalculateService();

        // input 값 입력
        String inputValue = inputView.inputView();
        // split 로 나누기
        String[] splitStrings = calculateService.split(inputValue);
        // Number 만 뻬서 보기
        List<Number> numbers = calculateService.sectionNumber(splitStrings);
        // 공식만 빼서 보기
        List<CalculatorSign> calculatorSigns = calculateService.sectionCalculate(splitStrings);
        // 계산
        int result = calculateService.iterNumbersAndCalculatorSigns(numbers, calculatorSigns);
        // 프린트
        outputView.print(result);
    }
}
