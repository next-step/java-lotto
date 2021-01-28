package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {
    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static final List<Integer> LOTTO_NUMBERS_RANGE = IntStream.range(1, 46).boxed()
            .collect(Collectors.toCollection(ArrayList::new));

    private final List<Integer> lottoNumbers;

    public LottoTicket() {
        lottoNumbers = makeLottoNumbers();
        sortLottoNumbers();
    }

    public LottoTicket(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        sortLottoNumbers();
    }

    public List<Integer> makeLottoNumbers() {
        Collections.shuffle(LOTTO_NUMBERS_RANGE);
        return LOTTO_NUMBERS_RANGE.subList(0, 6);
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public void sortLottoNumbers() {
        Collections.sort(lottoNumbers);
    }
}
