package com.nextstep.camp.lotto.domain.entity;

import com.nextstep.camp.lotto.domain.type.Rank;
import com.nextstep.camp.lotto.domain.vo.LottoNumbers;
import com.nextstep.camp.lotto.domain.vo.WinningNumbers;

import java.util.List;

public class LottoTicket {
    private final LottoNumbers lottoNumbers;

    private LottoTicket(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    private LottoTicket(List<Integer> rawNumbers) {
        this(LottoNumbers.of(rawNumbers));
    }

    public static LottoTicket of(LottoNumbers lottoNumbers) {
        return new LottoTicket(lottoNumbers);
    }

    public static LottoTicket of(List<Integer> rawNumbers) {
        return new LottoTicket(rawNumbers);
    }

    public Rank match(WinningNumbers winning) {
        int matchCount = lottoNumbers.countMatch(winning.getWinningNumbers());
        boolean bonusMatch = lottoNumbers.contains(winning.getBonusNumber());
        return Rank.of(matchCount, bonusMatch);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
