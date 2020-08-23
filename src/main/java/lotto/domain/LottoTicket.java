package lotto.domain;

import lotto.exception.LottoException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {

    private static final int LOTTO_NUMBERS_SIZE = 6;

    private List<Integer> lottoTicket;

    public LottoTicket(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoTicket = new ArrayList<>();
        buyingLottoTicket(lottoNumberGenerator, lottoTicket);
    }

    private List<Integer> buyingLottoTicket(LottoNumberGenerator lottoNumberGenerator, List<Integer> lottoTicket) {
        isLottoNumberAdd(lottoNumberGenerator, lottoTicket);
        return lottoTicket;
    }

    private boolean isLottoNumberAdd(LottoNumberGenerator lottoNumberGenerator, List<Integer> lottoTicket) {
        return lottoTicket.addAll(
                lottoNumberGenerator.getLottoNumbers()
                        .stream()
                        .distinct()
                        .limit(LOTTO_NUMBERS_SIZE)
                        .sorted()
                        .collect(Collectors.toList()));
    }

    public void lottoNumberRangeException(LottoTicket lottoTicket) {
        for (int number : lottoTicket.lottoTicket) {
            LottoException.lottoNumberRangeCheck(number);
        }
    }

    public List<Integer> getLottoTicket() {
        return lottoTicket;
    }

    public long count() {
        return lottoTicket.stream()
                .count();
    }

    public Integer getLottoTicketNumber(int index) {
        return lottoTicket.get(index);
    }

    @Override
    public String toString() {
        return String.valueOf(lottoTicket);
    }

}
