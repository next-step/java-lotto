package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {

    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;

    public static List<Integer> lottoGenerator(){

        List<Integer> lottoNumber = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
            .mapToObj(Integer::valueOf)
            .collect(Collectors.toList());

        Collections.shuffle(lottoNumber);
        List<Integer> sortedLottoNumber = lottoNumber.subList(0,6);
        Collections.sort(sortedLottoNumber);

        return sortedLottoNumber;
    }
}
