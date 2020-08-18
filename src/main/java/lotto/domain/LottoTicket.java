package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.domain.LottoNumbers.*;

public class LottoTicket {

    private static final int LOTTO_NUMBERS_SIZE = 6;

    private List<Integer> lottoTicket;

    public LottoTicket(LottoNumbers lottoNumbers) {
        this.lottoTicket = new ArrayList<>();
        buyingLottoTicket(lottoNumbers, lottoTicket);
    }

    private List<Integer> buyingLottoTicket(LottoNumbers lottoNumbers, List<Integer> lottoTicket) {
        getLottoNumber(lottoNumbers, lottoTicket);
        return lottoTicket;
    }

    private boolean getLottoNumber(LottoNumbers lottoNumbers, List<Integer> lottoTicket) {
        if (lottoNumbers == null) {
            lottoNumbers = new LottoNumbers();
        }
        return lottoTicket.addAll(
                lottoNumbers.getLottoNumbers()
                .distinct()
                .limit(LOTTO_NUMBERS_SIZE)
                .sorted()
                .collect(Collectors.toList()));
    }

    public void lottoNumberRangeException(LottoTicket lottoTicket) {
        for (int number : lottoTicket.lottoTicket) {
            lottoNumberRangeCheck(number);
        }
    }

    private void lottoNumberRangeCheck(int number) {
        if (number < LOTTO_BASE_END_NUMBER || number < LOTTO_BASE_START_NUMBER) {
            throw new RuntimeException(INVALID_LOTTO_NUMBER);
        }
    }

    public Stream<Integer> getLottoTicket() {
        return lottoTicket.stream();
    }

    public long count() {
        return lottoTicket.stream()
                .count();
    }
}
