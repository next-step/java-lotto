package lotto.domain;

import lotto.common.ErrorCode;
import lotto.common.WinningType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class LottoTicket {
    public static final int LOTTO_NUMBERS_LENGTH = 6;
    private final List<LottoNumber> LOTTO_NUMBERS;

    public LottoTicket() {
        this.LOTTO_NUMBERS = new LottoTicketGenerator().generate();
    }

    public LottoTicket(String lottoNumbersText) {
        List<LottoNumber> test =new LottoTicketGenerator().generate(lottoNumbersText);
        this.LOTTO_NUMBERS = new LottoTicketGenerator().generate(lottoNumbersText);
    }

    public LottoNumber[] toArray() {
        return this.LOTTO_NUMBERS.toArray(new LottoNumber[LOTTO_NUMBERS.size()]);
    }

    public WinningType findWinningType(LottoTicket winningLottoTicket) {
        int matchCount = 0;
        for (LottoNumber winningLottoNumber : winningLottoTicket.toArray()) {
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
