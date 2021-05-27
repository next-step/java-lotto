package kr.aterilio.nextstep.techcamp.m1.lotto;

import kr.aterilio.nextstep.techcamp.m1.utils.LottoParser;

public class LuckyNumbers {

    private final Lotto luckyNumber;

    public LuckyNumbers(String inputLuckyNumbers) {
        this.luckyNumber = new Lotto(LottoParser.parse(inputLuckyNumbers));
    }

    public int count() {
        return luckyNumber.count();
    }

    public int matchCount(Lotto lotto) {
        return luckyNumber.matchCount(lotto);
    }
}
