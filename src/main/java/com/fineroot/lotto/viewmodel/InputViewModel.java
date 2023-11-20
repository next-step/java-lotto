package com.fineroot.lotto.viewmodel;

import com.fineroot.lotto.dto.Money;
import com.fineroot.lotto.dto.WinningNumber;

public class InputViewModel {
    private Money money;
    private WinningNumber winningNumber;

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

    public Money getMoney() {
        return money;
    }

    public WinningNumber getWinningNumber(){
        return winningNumber;
    }
}
