import domain.Numbers;
import domain.SafeNumber;
import util.StringParser;
import view.InputView;
import view.OutputView;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class StringAdderController {
    public static void main(String[] args) {
        String input = InputView.input();
        List<Integer> parsedNumbers = StringParser.parse(input);

        List<SafeNumber> safeNumbers = parsedNumbers.stream()
                .map(SafeNumber::new)
                .collect(toList());

        Numbers numbers = new Numbers(safeNumbers);

        OutputView.output(numbers.getSum());
    }
}
