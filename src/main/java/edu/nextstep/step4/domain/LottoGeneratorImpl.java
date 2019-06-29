package edu.nextstep.step4.domain;

import java.util.List;
import java.util.stream.Collectors;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-lotto
 * create date  : 2019-06-30 02:05
 */
public class LottoGeneratorImpl implements LottoGenerator {
    @Override
    public List<Lotto> generate(List<String> manualLottos) {
        return manualLottos.stream()
                .map(manualLotto -> Lotto.createLotteryNumber(manualLotto))
                .collect(Collectors.toList());
    }
}
