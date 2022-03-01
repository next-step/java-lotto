package calculator;

import calculator.domain.Calculator;
import calculator.utils.DelimiterTokenizer;
import calculator.utils.NumberExtractor;
import calculator.view.InputView;
import calculator.view.ResultView;
import java.util.List;

public class CalculatorApplication {

    public static void main(String[] args) {
        try {
            final String text = InputView.inputText();
            final List<String> delimiters = DelimiterTokenizer.getDelimiters(text);
            final List<Integer> numbers = NumberExtractor.splitNumbersByDelimiter(text, delimiters);
            final Calculator calculator = new Calculator();
            ResultView.printResult(calculator.add(text, numbers));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
