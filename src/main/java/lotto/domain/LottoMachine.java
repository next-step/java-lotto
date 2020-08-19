package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    public static final int LOTTO_START_NUMBER = 1;
    public static final int LOTTO_END_NUMBER = 45;
    public static final int LOTTO_NUMBER_COUNT = 6;

    private static List<Integer> lottoNumbers = new ArrayList<>();

    private LottoMachine() {
        lottoNumbers = IntStream.rangeClosed(LOTTO_START_NUMBER, LOTTO_END_NUMBER)
                .boxed().collect(Collectors.toList());
    }

    public static LottoMachine getInstance() {
        return new LottoMachine();
    }

    public static Set<LottoNumber> generateLottoNumber() {
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.subList(0, LOTTO_NUMBER_COUNT).stream()
                .map(number -> new LottoNumber(number))
                .collect(Collectors.toSet());
    }

    public static Set<LottoNumber> createManualLottoNumbers(List<Integer> manualLottoNumbers) {
        Set<Integer> deduplicatedManualLottoNumbers = new HashSet<>(manualLottoNumbers);
        Set<LottoNumber> lotto = new HashSet<>();

        for (Integer deduplicatedManualLottoNumber : deduplicatedManualLottoNumbers) {
            lotto.add(new LottoNumber(deduplicatedManualLottoNumber));
        }
        return lotto;
    }
}
