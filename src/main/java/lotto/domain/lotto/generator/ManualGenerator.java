package lotto.domain.lotto.generator;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.number.Numbers;

public class ManualGenerator implements Generator {

    private final List<Numbers> entireNumbers;

    public ManualGenerator(final List<Numbers> entireNumbers) {
        this.entireNumbers = entireNumbers.stream()
            .map(Numbers::new)
            .collect(Collectors.toList());
    }

    @Override
    public List<Lotto> generateLottos(int count) {
        return entireNumbers.stream()
            .map(Numbers::new)
            .map(Lotto::new)
            .collect(Collectors.toList());
    }
}
