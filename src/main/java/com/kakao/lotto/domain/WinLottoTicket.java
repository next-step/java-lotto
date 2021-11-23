package com.kakao.lotto.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinLottoTicket {

    protected final Set<LottoNumber> lottoNumbers;
    private final LottoNumber bonus;

    private WinLottoTicket(Set<LottoNumber> lottoNumbers, LottoNumber bonus) {
        validNumber(lottoNumbers, bonus);
        this.lottoNumbers = lottoNumbers;
        this.bonus = bonus;
    }

    public static WinLottoTicket of(List<Integer> winLottoNumbers, int bonus) {
        Set<LottoNumber> correctLottoNumbers = winLottoNumbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toSet());
        return new WinLottoTicket(correctLottoNumbers, LottoNumber.of(bonus));
    }

    public LottoRank matchLottoRank(LottoTicket lottoTicket) {
        int correctMatch = (int) lottoNumbers.stream()
                .filter(lottoTicket.lottoNumbers::contains)
                .count();
        boolean matchBonus = lottoTicket.lottoNumbers.contains(bonus);
        return LottoRank.findByMatchRank(correctMatch, matchBonus);
    }

    private void validNumber(Set<LottoNumber> lottoNumbers, LottoNumber bonus){
        if (lottoNumbers.size() != LottoTicket.LOTTO_SIZE){
            throw new IllegalArgumentException("입력된 로또 숫자 개수가 올바르지 않습니다");
        }
        if(lottoNumbers.contains(bonus)){
            throw new IllegalArgumentException("보너스 숫자가 입력된 로또 번호와 중복입니다");
        }
    }


}
