package lotto.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class WinningTexts {

    private WinningTexts() {

    }

    public static Set<LottoNumber> numbers(String[] text) {
        return toLottoNumbers(text);
    }

    private static Set<LottoNumber> toLottoNumbers(String[] values) {
        List<LottoNumber> result = new ArrayList<>();
        for (String value : values) {
            result.add(new LottoNumber(toInt(value)));
        }
        return new HashSet<>(result);
    }

    private static Integer toInt(String value) {
        return Integer.parseInt(value);
    }

}
