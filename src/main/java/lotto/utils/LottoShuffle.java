package lotto.utils;

import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.Lotto.LOTTO_SIZE;

public class LottoShuffle {

    private static int LOTTO_MAX_NUMBER = 45;
    private static int LOTTO_MIN_NUMBER = 1;
    private static List<Integer> lottoGameNumber = IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER).boxed().collect(Collectors.toList());

    private LottoShuffle() {
    }

    public static List<LottoNumber> makeLottoNumber() {

        Collections.shuffle(lottoGameNumber);
        List<LottoNumber> lottoNumbers = lottoGameNumber.stream().limit(LOTTO_SIZE).map(number -> new LottoNumber(number)).collect(Collectors.toList());
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }


}
