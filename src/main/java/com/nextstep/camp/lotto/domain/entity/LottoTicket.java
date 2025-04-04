package com.nextstep.camp.lotto.domain.entity;

import java.util.List;

import com.nextstep.camp.lotto.domain.type.MatchResult;
import com.nextstep.camp.lotto.domain.vo.LottoNumbers;
import com.nextstep.camp.lotto.domain.vo.WinningNumbers;

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

    public MatchResult match(WinningNumbers winning) {
        int matchCount = lottoNumbers.countMatch(winning.getNumbers());
        boolean bonusMatch = lottoNumbers.contains(winning.getBonusNumber());
        return MatchResult.of(matchCount, bonusMatch);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
