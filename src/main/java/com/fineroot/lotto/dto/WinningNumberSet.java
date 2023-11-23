package com.fineroot.lotto.dto;

import com.fineroot.lotto.domain.LottoNumber;
import com.fineroot.lotto.util.ExceptionMessage;
import java.util.Collection;

public class WinningNumberSet {
    private final WinningNumber winningNumber;
    private final LottoNumber bonusNumber;

    private WinningNumberSet(WinningNumber winningNumber, LottoNumber bonusNumber) {
        if(winningNumber.contains(bonusNumber)){
            throw new IllegalArgumentException(ExceptionMessage.BONUS_NUMBER_DUPLICATED.getMessage());
        }
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumberSet of(String winningNumber, String bonusNumber) {
        return new WinningNumberSet(WinningNumber.from(winningNumber), LottoNumber.from(Integer.parseInt(bonusNumber)));
    }

    public static WinningNumberSet of(WinningNumber winningNumber, LottoNumber bonusNumber) {
        return new WinningNumberSet(winningNumber, bonusNumber);
    }

    public boolean contains(LottoNumber lottoNumber){
        return winningNumber.contains(lottoNumber);
    }

    public boolean hasBonus(Collection<LottoNumber> bonusNumber){
        return bonusNumber.contains(this.bonusNumber);
    }

}
