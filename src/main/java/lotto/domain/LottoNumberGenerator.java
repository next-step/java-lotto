package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberGenerator {
    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 45;

    public static List<Integer> createLottoNumber() {
        List<Integer> lottoNumber = new ArrayList<>();

        for (int i = START_NUMBER; i <= END_NUMBER; i++) {
            lottoNumber.add(i);
        }
        Collections.shuffle(lottoNumber);

        return lottoNumber.stream()
                .limit(6)
                .collect(Collectors.toList());
    }

    public static List<Integer> createLottoNumber(List<Integer> numbers) {
        List<Integer> lottoNumber = new ArrayList<>();
        lottoNumber.addAll(numbers);
        Collections.sort(lottoNumber);
        return lottoNumber;
    }
}
