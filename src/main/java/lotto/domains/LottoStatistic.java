package lotto.domains;

public class LottoStatistic {
    private int count;
    private int payout;

    public LottoStatistic() {
        this.count = 0;
        this.payout = 0;
    }

    public void add() {
        //TODO Enum적용 예정
        this.count++;
        this.payout += 5000;
    }

    public int count() {
        return count;
    }

    public int payout() {
        return payout;
    }
}
