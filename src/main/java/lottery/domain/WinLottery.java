package lottery.domain;

import lottery.domain.vo.LotteryNumbers;

public class WinLottery {
    private final Lottery winLottery;

    public WinLottery(LotteryNumbers winNumbers) {
        this.winLottery = new Lottery(winNumbers);
    }

    public WinLottery(String winNumbersString) {
        this(createWinLottery(winNumbersString));
    }

    private static LotteryNumbers createWinLottery(String winNumbersString){
        return new LotteryNumbers(winNumbersString);
    }

    public Lottery winLottery(){
        return this.winLottery;
    }

}
