package edu.nextstep.step4.domain;

import edu.nextstep.step4.utils.RandomNumberUtils;

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
 * create date  : 2019-06-26 23:00
 */
public class LottoStore {

    public static Lottos publishLotto(Money money, List<String> manualLottos) {
        int issueNumber = money.getNumberOfExtract();

        List<Lotto> exLotto = manualLottos.stream()
                .map(manualLotto -> Lotto.createLotteryNumber(manualLotto))
                .collect(Collectors.toList());

        for (int i = 0; i < issueNumber; i++) {
            exLotto.add(issueLottoNumber());
        }
        return new Lottos(exLotto);
    }

    private static Lotto issueLottoNumber() {
        return new Lotto(RandomNumberUtils.getExtractNumber().stream()
                .map(number -> Number.of(number))
                .collect(Collectors.toList()));
    }

}
