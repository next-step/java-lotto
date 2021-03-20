package study.lotto.generator;

import study.lotto.domain.LottoNumber;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static study.lotto.view.InputView.SPLIT_DELIMITER;

public class ManualLottoNumberGenerator implements NumberGenerator {

    @Override
    public List<LottoNumber> generate(final String manualNumbers) {
        return Arrays.stream(manualNumbers.split(SPLIT_DELIMITER))
                .map(LottoNumber::new)
                .collect(toList());
    }
}
