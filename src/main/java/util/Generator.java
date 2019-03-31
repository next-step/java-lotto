package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Generator {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int MAX_LOTTO_NUMBER_COUNT = 6;

//    public static List<LottoNo> lottoNumbers() {
//        return createLotto(initLottoNumbers(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER))
//                .stream()
//                .map(i -> LottoNo.of(i)).collect(Collectors.toList());
//    }
//
//    private static List<LottoNo> initLottoNumbers(int minNumber, int maxNumber) {
//        List<LottoNo> lottoNumbers = new ArrayList<>();
//        IntStream.range(minNumber, maxNumber + 1).forEach(i -> lottoNumbers.add(LottoNo.of(i)));
//        Collections.shuffle(lottoNumbers);
//        return lottoNumbers;
//    }

    public static List<Integer> lottoNumbers() {
        return createLotto(initLottoNumbers(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER));
    }

    private static List<Integer> initLottoNumbers(int minNumber, int maxNumber) {
        List<Integer> lottoNumbers = new ArrayList<>();
        IntStream.range(minNumber, maxNumber + 1).forEach(i -> lottoNumbers.add((i)));
        Collections.shuffle(lottoNumbers);
        return lottoNumbers;
    }

    private static List<Integer> createLotto(List<Integer> lottoNumbers) {
        List<Integer> lotto = new ArrayList<>();
        IntStream.range(0, MAX_LOTTO_NUMBER_COUNT).forEach(i -> lotto.add(Integer.parseInt(lottoNumbers.get(i).toString())));
        Collections.sort(lotto);
        return lotto;
    }
}