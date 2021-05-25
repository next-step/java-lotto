package lotto.domain;

import lotto.common.WinningType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private final List<LottoNumber> LOTTO_NUMBERS;

    public LottoTicket() {
        this.LOTTO_NUMBERS = new ArrayList<>(new LottoTicketGenerator().generate());
    }

    public LottoTicket(String lottoNumbersText) {
        this.LOTTO_NUMBERS = new ArrayList<>(new LottoTicketGenerator().generate(lottoNumbersText));
    }

    public List<LottoNumber> getLottoTicket() {
        return Collections.unmodifiableList(this.LOTTO_NUMBERS);
    }

    public WinningType getWinningType(LottoTicket winningLottoTicket) {
        int matchCount = 0;
        for (LottoNumber winningLottoNumber : winningLottoTicket.getLottoTicket()) {
            matchCount += contains(winningLottoNumber);
        }
        return WinningType.of(matchCount);
    }

    private int contains(LottoNumber winningLottoNumber) {
        if (this.LOTTO_NUMBERS.contains(winningLottoNumber)) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return this.LOTTO_NUMBERS.toString();
    }
}
