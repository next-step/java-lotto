package lotto.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {

    private static final List<Integer> lottoNumbers = IntStream.rangeClosed(1, 46).boxed().collect(Collectors.toList());
    private static final int NUMBERS_SIZE = 6;

    private LottoNumberGenerator() {}

    public static List<Integer> getRandomLottoNumber() {
        List<Integer> shuffledLottoNumbers = new ArrayList<>(lottoNumbers);
        Collections.shuffle(shuffledLottoNumbers);
        return shuffledLottoNumbers.subList(0, NUMBERS_SIZE);
    }

}

