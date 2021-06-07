package kr.aterilio.nextstep.techcamp.m1.utils;

public class LottoParser {

    public static Integer[] parse(String inputNumbers) {
        String[] split = inputNumbers.split(",");
        return StringUtil.convertToIntegerArray(split);
    }
}
