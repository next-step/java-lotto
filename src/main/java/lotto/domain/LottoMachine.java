package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final List<Integer> lottoNumbers;
    private static final LottoMachine instance = new LottoMachine();

    static {
        lottoNumbers = new ArrayList<>();
        IntStream.rangeClosed(LOTTO_START_NUMBER, LOTTO_END_NUMBER)
                .boxed().distinct().forEach(lottoNumbers::add);
    }

    private LottoMachine() {
    }

    public static LottoMachine instance() {
        return instance;
    }

    public LottoTicket generateAutoLottoNumber() {
        Collections.shuffle(lottoNumbers);
        return new LottoTicket(lottoNumbers.subList(0, LOTTO_NUMBER_COUNT).stream()
                .map(number -> LottoNumber.ofNumber(number))
                .collect(Collectors.toSet()));
    }

    public LottoTicket generateManualLottoNumbers(LottoNumbers manualLottoNumbers) {
        Set<Integer> deduplicatedManualLottoNumbers = new HashSet<>(manualLottoNumbers.getNumbers());
        Set<LottoNumber> lottoNumbers = new HashSet<>();

        for (Integer deduplicatedManualLottoNumber : deduplicatedManualLottoNumbers) {
            lottoNumbers.add(LottoNumber.ofNumber(deduplicatedManualLottoNumber));
        }

        return new LottoTicket(lottoNumbers);
    }
}
