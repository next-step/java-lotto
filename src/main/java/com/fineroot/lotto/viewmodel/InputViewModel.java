package com.fineroot.lotto.viewmodel;

import com.fineroot.lotto.domain.LottoNumber;
import com.fineroot.lotto.dto.Money;
import com.fineroot.lotto.dto.WinningNumber;
import com.fineroot.lotto.dto.WinningNumberSet;

public class InputViewModel {
    private Money money;
    private WinningNumber winningNumber;

    private LottoNumber bonusNumber;

    public InputViewModel(){
        this.money = Money.from(0);
        this.winningNumber = WinningNumber.defaultCreate();
    }

    public void saveMoney(Money money){
        this.money = money;
    }

    public void saveWinningNumber(WinningNumber winningNumber){
        this.winningNumber = winningNumber;
    }

    public void saveBonusNumber(LottoNumber number){
        this.bonusNumber=number;
    }

    public Money getMoney() {
        return money;
    }

    public WinningNumberSet getWinningNumberSet(){
        return WinningNumberSet.of(winningNumber, bonusNumber);
    }
}
