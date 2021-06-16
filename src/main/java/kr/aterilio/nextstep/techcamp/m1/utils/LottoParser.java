package kr.aterilio.nextstep.techcamp.m1.utils;

import kr.aterilio.nextstep.techcamp.m1.lotto.LottoBall;

public class LottoParser {

    public static LottoBall[] parse(String inputNumbers) {
        String[] split = inputNumbers.split(",");
        return convertToIntegerArray(split);
    }

    public static LottoBall[] convertToIntegerArray(String[] targets) {
        LottoBall[] convert = new LottoBall[targets.length];
        for (int i = targets.length-1; i >= 0; --i) {
            String target = targets[i].trim();
            convert[i] = LottoBall.of(target);
        }
        return convert;
    }
}
