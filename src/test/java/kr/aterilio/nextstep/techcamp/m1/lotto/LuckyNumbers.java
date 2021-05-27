package kr.aterilio.nextstep.techcamp.m1.lotto;

import kr.aterilio.nextstep.techcamp.m1.utils.StringUtil;

public class LuckyNumbers {

    private final Lotto luckyNumber;

    public LuckyNumbers(String inputLuckyNumbers) {
        this.luckyNumber = new Lotto(parse(inputLuckyNumbers));
    }

    private Integer[] parse(String inputLuckyNumbers) {
        String[] split = inputLuckyNumbers.split(",");
        return StringUtil.convertToIntegerArray(split);
    }

    public int count() {
        return luckyNumber.count();
    }
}
