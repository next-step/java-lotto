package step2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {
    private static final String DELIMITER = ", ";
    private final List<Integer> lottoNumbers;

    public LottoGenerator() {
        this.lottoNumbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            lottoNumbers.add(i);
        }
    }

    public List<Lotto> generateLottos(int lottoPurchaseCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoPurchaseCount; i++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    private Lotto generateLotto() {
        Collections.shuffle(lottoNumbers);
        return new Lotto(lottoNumbers.subList(0, 6));
    }

    public Lotto generateWinningLotto(String userInput) {
        return new Lotto(parseWinningNumbers(splitWinningNumbers(userInput)));
    }

    private List<Integer> parseWinningNumbers(List<String> splitWinningNumbers) {
        return splitWinningNumbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private List<String> splitWinningNumbers(String userInput) {
        return List.of(userInput.split(DELIMITER));
    }
}
