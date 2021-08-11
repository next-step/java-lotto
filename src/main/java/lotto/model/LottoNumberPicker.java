package lotto.model;

import lotto.util.LottoNumberUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberPicker {

    private static List<LottoNumber> numbers = new ArrayList<>();

    static {
        for (int number = LottoNumberUtil.getLottoStartNumber();
             number <= LottoNumberUtil.getLottoEndNumber(); number++) {
            numbers.add(new LottoNumber(number));
        }
    }

    public static LottoNumber pickNumber() {
        Collections.shuffle(numbers);
        return numbers.get(0);
    }

    public static LottoNumber pickNumber(int number) {
        LottoNumberUtil.validNumber(number);
        return numbers.stream()
                .filter(lottoNumber -> lottoNumber.getLottoNumber() == number)
                .findAny().get();
    }

}
