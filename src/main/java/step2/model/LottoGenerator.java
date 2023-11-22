package step2.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public List<Lotto> generateLottos(Money money) {

        List<Lotto> lottos = generateManualLottos(getUserInputs(money));

        lottos.addAll(generateAutoLottos(money));

        return lottos;
    }

    private static List<String> getUserInputs(Money money) {
        int manualLottoCount = 2; //todo InputView
        money.purchaseManualLotto(manualLottoCount);
        return Arrays.asList("1, 2, 3, 4, 5, 6", "7, 8, 9, 10, 11, 12");
    }

    public List<Lotto> generateManualLottos(List<String> userInputs) {
        return userInputs.stream()
                .map(this::generateManualLotto)
                .collect(Collectors.toList());
    }

    Lotto generateManualLotto(String userInput) {
        return new Lotto(parseLottoNumbers(splitLottoNumbers(userInput)));
    }

    private List<Lotto> generateAutoLottos(Money money) {
        return IntStream.range(0, money.determineLottoPurchaseCount())
                .mapToObj(count -> generateAutoLotto())
                .collect(Collectors.toList());
    }

    private Lotto generateAutoLotto() {
        Collections.shuffle(lottoNumbers);
        return new Lotto(lottoNumbers.subList(0, LOTTO_SIZE));
    }

    public WinningLotto generateWinningLotto(String userInput, Integer bonusNumber) {
        return new WinningLotto(parseLottoNumbers(splitLottoNumbers(userInput)), bonusNumber);
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
