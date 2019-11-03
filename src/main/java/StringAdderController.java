import domain.Numbers;
import domain.SafeNumber;
import util.ParseStrategy;
import util.ParserGroup;
import view.InputView;
import view.OutputView;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class StringAdderController {
    public static void main(String[] args) {
        String input = InputView.input();

        ParseStrategy strategy = ParserGroup.findStrategyByInput(input);

        List<String> parsedInput = strategy.parse();

        List<SafeNumber> safeNumbers = parsedInput.stream()
                .map(SafeNumber::new)
                .collect(toList());

        Numbers numbers = new Numbers(safeNumbers);

        OutputView.output(numbers.getSum());
    }
}
