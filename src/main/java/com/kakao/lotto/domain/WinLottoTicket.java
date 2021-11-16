package com.kakao.lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class WinLottoTicket extends LottoTicket {

    private WinLottoTicket(List<LottoNumber> lottoNumbers) {
        super(lottoNumbers);
    }

    public static WinLottoTicket of(List<Integer> winLottoNumbers) {
        List<LottoNumber> correctLottoNumbers = winLottoNumbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList());
        return new WinLottoTicket(correctLottoNumbers);
    }

    public int matchWinNumber(LottoTicket lottoTicket) {
        return (int) lottoNumbers.stream()
                .filter(lottoTicket.lottoNumbers::contains)
                .count();
    }


}
