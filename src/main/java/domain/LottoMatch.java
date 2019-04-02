package domain;


public class LottoMatch {

    private LottoProfit profit;

    public LottoMatch(WinningLotto winningLotto, Lotto userLotto){
        this.profit = winningLotto.match(userLotto);
    }

    public LottoProfit getProfit() {
        return profit;
    }
}
