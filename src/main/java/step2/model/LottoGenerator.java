package step2.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;
    private static final String DELIMITER = ", ";
    private final List<Integer> lottoNumbers;

    public LottoGenerator() {
        this.lottoNumbers = new ArrayList<>();
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
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
        return new Lotto(lottoNumbers.subList(0, LOTTO_SIZE));
    }

    public WinningLotto generateWinningLotto(String userInput, Integer bonusNumber) {
        return new WinningLotto(parseLottoNumbers(splitLottoNumbers(userInput)), bonusNumber);
    }

    public Lotto generateManualLotto(String userInput) {
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
