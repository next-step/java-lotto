package com.kakao.lotto.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinLottoTicket extends LottoTicket {

    private final int bonus;

    private WinLottoTicket(Set<LottoNumber> lottoNumbers, int bonus) {
        super(lottoNumbers);
        this.bonus = bonus;
    }

    public static WinLottoTicket of(List<Integer> winLottoNumbers, int bonus) {
        Set<LottoNumber> correctLottoNumbers = winLottoNumbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toSet());
        return new WinLottoTicket(correctLottoNumbers, bonus);
    }

    public LottoRank matchLottoRank(LottoTicket lottoTicket) {
        int correctMatch = (int) lottoNumbers.stream()
                .filter(lottoTicket.lottoNumbers::contains)
                .count();
        boolean matchBonus = lottoTicket.lottoNumbers.contains(LottoNumber.of(bonus));
        return LottoRank.findByMatchRank(correctMatch, matchBonus);
    }


}
