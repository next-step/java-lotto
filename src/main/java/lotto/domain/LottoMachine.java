package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    public static final int LOTTO_START_NUMBER = 1;
    public static final int LOTTO_END_NUMBER = 45;
    public static final int LOTTO_NUMBER_COUNT = 6;
    private static final List<Integer> lottoNumbers;

    static {
        lottoNumbers = new ArrayList<>();
        IntStream.rangeClosed(LOTTO_START_NUMBER, LOTTO_END_NUMBER)
                .boxed().distinct().forEach(lottoNumbers::add);
    }

    public LottoTicket generateLottoNumber() {
        Collections.shuffle(lottoNumbers);
        return new LottoTicket(lottoNumbers.subList(0, LOTTO_NUMBER_COUNT).stream()
                .map(number -> LottoNumber.ofNumber(number))
                .collect(Collectors.toSet()));
    }

    public LottoTicket createManualLottoNumbers(List<Integer> manualLottoNumbers) {
        Set<Integer> deduplicatedManualLottoNumbers = new HashSet<>(manualLottoNumbers);
        Set<LottoNumber> lottoNumbers = new HashSet<>();

        for (Integer deduplicatedManualLottoNumber : deduplicatedManualLottoNumbers) {
            lottoNumbers.add(LottoNumber.ofNumber(deduplicatedManualLottoNumber));
        }
        return new LottoTicket(lottoNumbers);
    }
}
