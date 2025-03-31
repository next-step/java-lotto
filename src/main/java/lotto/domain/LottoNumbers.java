package lotto.domain;

import java.util.*;

public class LottoNumbers {
    private static final List<LottoNumber> NUMBERS = Arrays.asList(LottoNumber.values());

    public static List<LottoNumber> generate() {
        List<LottoNumber> all = new ArrayList<>(NUMBERS);
        Collections.shuffle(all);
        List<LottoNumber> numbers = all.subList(0, Lotto.NUMBER_COUNT);
        numbers.sort(Comparator.comparingInt(LottoNumber::getValue));
        return numbers;
    }
}
