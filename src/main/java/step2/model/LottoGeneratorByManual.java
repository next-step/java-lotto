package step2.model;

import java.util.List;
import java.util.stream.Collectors;

public class LottoGeneratorByManual implements LottoGenerator {

    private static final String DELIMITER = ", ";

    private final String userInput;

    public LottoGeneratorByManual(final String userInput) {
        this.userInput = userInput;
    }

    @Override
    public Lotto generateLotto() {
        return new Lotto(parseLottoNumbers(splitLottoNumbers(userInput)));
    }

    private List<Integer> parseLottoNumbers(List<String> splitWinningNumbers) {
        return splitWinningNumbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private List<String> splitLottoNumbers(String userInput) {
        return List.of(userInput.split(DELIMITER));
    }
}
