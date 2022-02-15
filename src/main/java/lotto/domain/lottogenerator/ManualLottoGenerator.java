package lotto.domain.lottogenerator;

import java.util.Arrays;
import java.util.stream.Collectors;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;

public class ManualLottoGenerator implements LottoGenerator {

    private static final String DELIMITER = ",";

    private final Lotto lotto;

    public ManualLottoGenerator(String manualLotto) {
        this.lotto = Arrays.stream(manualLotto.split(DELIMITER))
            .map(String::trim)
            .map(LottoNumber::new)
            .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::from));
    }

    @Override
    public Lotto generateLotto() {
        return lotto;
    }
}
