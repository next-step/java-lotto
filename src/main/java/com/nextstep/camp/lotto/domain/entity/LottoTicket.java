package com.nextstep.camp.lotto.domain.entity;

import com.nextstep.camp.lotto.domain.vo.LottoNumbers;
import com.nextstep.camp.lotto.domain.vo.WinningNumbers;

import java.util.List;

public class LottoTicket {
    private final LottoNumbers lottoNumbers;

    private LottoTicket(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    private LottoTicket(List<Integer> rawNumbers) {
        this.lottoNumbers = LottoNumbers.of(rawNumbers);
    }

    public static LottoTicket of(LottoNumbers lottoNumbers) {
        return new LottoTicket(lottoNumbers);
    }

    public static LottoTicket of(List<Integer> rawNumbers) {
        return new LottoTicket(rawNumbers);
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }

    public int countMatch(WinningNumbers winning) {
        return lottoNumbers.countMatch(winning.getNumbers());
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
