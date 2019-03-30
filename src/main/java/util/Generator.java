package util;

import domain.LottoNo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Generator {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int MAX_LOTTO_NUMBER_COUNT = 6;

    public static List<LottoNo> lottoNumbers() {
        return createLotto(initLottoNumbers(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER))
                .stream()
                .map(i -> new LottoNo(i)).collect(Collectors.toList());
    }

    private static List<LottoNo> initLottoNumbers(int minNumber, int maxNumber) {
        List<LottoNo> lottoNumbers = new ArrayList<>();
        IntStream.range(minNumber, maxNumber + 1).forEach(i -> lottoNumbers.add(new LottoNo(i)));
        Collections.shuffle(lottoNumbers);
        return lottoNumbers;
    }

    private static List<Integer> createLotto(List<LottoNo> lottoNumbers) {
        List<Integer> lotto = new ArrayList<>();
        IntStream.range(0, MAX_LOTTO_NUMBER_COUNT).forEach(i -> lotto.add(Integer.parseInt(lottoNumbers.get(i).toString())));
        Collections.sort(lotto);
        return lotto;
    }
}