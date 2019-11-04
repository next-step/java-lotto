package step1;

import step1.domain.Numbers;
import step1.domain.SafeNumber;
import step1.util.ParseStrategy;
import step1.util.ParserGroup;
import step1.view.InputView;
import step1.view.OutputView;

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
