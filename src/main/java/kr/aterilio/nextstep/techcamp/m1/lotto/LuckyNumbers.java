package kr.aterilio.nextstep.techcamp.m1.lotto;

import kr.aterilio.nextstep.techcamp.m1.utils.LottoParser;

public class LuckyNumbers {

    private final Lotto luckyNumber;
    private final BonusBall bonusBall;

    public LuckyNumbers(String inputLuckyNumbers) {
        this(inputLuckyNumbers, 0);
    }

    public LuckyNumbers(String inputLuckyNumbers, int bonusBall) {
        this.luckyNumber = new Lotto(LottoParser.parse(inputLuckyNumbers));
        this.bonusBall = new BonusBall(bonusBall);
        validateDuplicate();
    }

    private void validateDuplicate() {
        if (luckyNumber.contains(bonusBall.ball())) {
            throw new IllegalArgumentException(Lotto.MSG_ERR_DUPLICATE);
        }
    }

    public int count() {
        return luckyNumber.count();
    }

    public int matchCount(Lotto lotto) {
        return luckyNumber.matchCount(lotto);
    }
}
