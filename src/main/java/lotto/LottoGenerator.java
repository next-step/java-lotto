package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    private static List<Integer> lottoBaseNumbers;

    private LottoGenerator() {
    }

    public static LottoNumber generate() {
        if (lottoBaseNumbers == null) {
            lottoBaseNumbers = IntStream.rangeClosed(1, 41).boxed().collect(Collectors.toList());
        }

        Collections.shuffle(lottoBaseNumbers);
        ArrayList<Integer> lottoNumber = new ArrayList<>(lottoBaseNumbers.subList(0, 6));
        Collections.sort(lottoNumber);
        return new LottoNumber(lottoNumber);
    }
}
