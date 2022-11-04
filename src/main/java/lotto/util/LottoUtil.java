package lotto.util;

import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.List;

public class LottoUtil {
    public static List<LottoNumber> CastingArrayToList(String[] strings) {
        List<LottoNumber> list = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            list.add(new LottoNumber(Integer.parseInt(removeSpace(strings[i]))));
        }
        return list;
    }

    private static String removeSpace(String lottoString) {
        return lottoString.replaceAll("\\s", "");
    }
}
