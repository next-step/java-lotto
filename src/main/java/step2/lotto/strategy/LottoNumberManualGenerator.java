package step2.lotto.strategy;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import step2.lotto.domain.Lotto;
import step2.lotto.domain.LottoPurchase;

public class LottoNumberManualGenerator implements LottoNumberGenerator {

    private final static String DELIMITER = ",";

    @Override
    public List<Lotto> generateLottos(LottoPurchase lottoPurchase) {
        return lottoPurchase.getLottoManualNumbers().stream()
            .map(manual -> Lotto.of(generateNumber(manual)))
            .collect(Collectors.toList());
    }

    private Set<Integer> generateNumber (final String inputManualNumbers) {
        return Arrays.stream(inputManualNumbers.split(DELIMITER))
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(Collectors.toSet());
    }

}
