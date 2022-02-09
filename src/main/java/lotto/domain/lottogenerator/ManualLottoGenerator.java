package lotto.domain.lottogenerator;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class ManualLottoGenerator implements LottoGenerator {

    private static final String DELIMITER = ",";

    private final Set<Integer> lottoNumber;

    public ManualLottoGenerator(String manualLotto) {
        this.lottoNumber = Arrays.stream(manualLotto.split(DELIMITER))
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(Collectors.toSet());
    }

    @Override
    public Set<Integer> generateLotto() {
        return lottoNumber;
    }
}
