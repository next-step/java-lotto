package step2.domain;

import java.math.BigDecimal;
import java.util.*;

public class LottoStore {

    private WinningLottoNumber winningLottoNumber;
    private Fee fee;
    private SoldLotto soldLotto;
    private WinningLottoMoney winningLottoMoney;

    public List<Lotto> buy(int fee) {
        this.fee = new Fee(fee);
        int buyCount = this.fee.getBuyCount();

        return buyLotto(buyCount);
    }

    private List<Lotto> buyLotto(int buyCount) {
        this.soldLotto = new SoldLotto(buyCount);
        return this.soldLotto.getSoldLotto();
    }

    public void initWinNumbers(List<Integer> winningNumbers) {
        this.winningLottoNumber = new WinningLottoNumber(winningNumbers);
    }

    public Map<LottoRank, Integer> findWinLottoMoney() {
        this.winningLottoMoney = new WinningLottoMoney(this.soldLotto, this.winningLottoNumber);
        return this.winningLottoMoney.getWinningLottoMoney();
    }

    public BigDecimal findBenefit() {
        return this.winningLottoMoney.findBenefitByFee(this.fee);
    }

    public List<Integer> getWinNumbers() {
        return this.winningLottoNumber.getNumbers();
    }
}
