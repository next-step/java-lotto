package lotto.domain;

public enum LottoResult {
    SeventhPrize(0),
    SixthPrize(0),
    FifthPrize(0),
    FourthPrize(5000),
    ThirdPrize(50000),
    SecondPrize(1500000),
    FirstPrize(2000000000)
    ;

    private int reward;
    LottoResult(int reward) {
        this.reward = reward;
    }

    public int getReward(){
        return this.reward;
    }
}
