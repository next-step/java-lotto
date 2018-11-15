package util;

import domain.LottoNo;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class ConsoleUtil {
    public static List<LottoNo> changeWinNumberToInteger(String winNumber) {
        return Arrays.stream(winNumber.split(","))
                .map(ConsoleUtil::apply)
                .collect(toList());
    }

    private static LottoNo apply(String s) {
        return new LottoNo(Integer.valueOf(s));
    }
}
