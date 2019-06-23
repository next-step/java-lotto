import java.util.List;

public class StringCalculator {

    public int calculate(String equation) {
        Extractor extractor = new Extractor(equation);

        List<Integer> numbers = extractor.getOperands(extractor.getDelimiter());

        return plusAll(numbers);
    }

    private int plusAll(List<Integer> numbers) {
        int result = 0;
        for (Integer number : numbers) {
            result += number;
        }

        return result;
    }
}