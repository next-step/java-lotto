package step1;

import java.util.List;

public class CalculationNumber {
    public final List<Integer> innerNumbers;

    public CalculationNumber(List<Integer> innerNumbers) {
        this.innerNumbers = innerNumbers;
    }

    public static CalculationNumber getCalculationNumbers(String inputCalculationNumbers) {
        return ConverterFactory.ofConverter(inputCalculationNumbers)
                .map(Converter::convertInputCalculationNumbers)
                .orElseThrow(() -> new RuntimeException("의미있는 숫자가 아닙니다."));
    }

    public List<Integer> getInnerNumbers() {
        return innerNumbers;
    }
}
