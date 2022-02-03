package lotto.domain;

import java.util.List;

public class Analyzer {
    private final int price;
    private  int winningMoney;

    public Analyzer(final int price) {
        this.price = price;
    }

    public Double calculateProfitPercent(){
        return this.winningMoney/(double)this.price;
    }

    public int calculateWinningMoney(final List<Integer>correctWinNumber,final List<Integer>hasBonusNumber){
        System.out.println(correctWinNumber+" "+hasBonusNumber);
        for (int i=0;i<correctWinNumber.size();i++){
            final WinningPrice winningPrice= WinningPrice.of(correctWinNumber.get(i), hasBonusNumber.get(i));
            int currency = winningPrice.getCurrency();
            System.out.println(currency);

        }
        return 0;

    }
}
