package edu.nextstep.step2;

import java.util.ArrayList;
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
 * create date  : 2019-06-25 00:02
 */
public class Lotto {

    private List<ExtractionNumber> lotto;

    public Lotto(List<ExtractionNumber> lotto) {
        this.lotto = new ArrayList<>(lotto);
    }

    public List<Integer> getMatchCountExtractNumberFromLotteryNumber(LotteryNumber lotteryNumber) {
        return lotto.stream()
                .map(extractionNumber -> lotteryNumber.compareMatchNumberCount(extractionNumber))
                .collect(Collectors.toList());
    }
}
