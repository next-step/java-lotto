package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.lotto.Lotto.END_NUMBER;
import static lotto.domain.lotto.Lotto.START_NUMBER;

public class AutoLottoNumbers {

    private static final List<Integer> lottoNumbers;

    static {
        lottoNumbers = IntStream.rangeClosed(START_NUMBER, END_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    public static List<Integer> autoNumbers() {
        return Collections.unmodifiableList(new ArrayList<>(lottoNumbers));
    }

}
