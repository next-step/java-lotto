package step2.domain;

import java.util.*;

public class LottoStore {
    private static final int ZERO = 0;

    private WinningLottoNumber winningLottoNumber;
    private Fee fee;
    private List<Lotto> soldLotto;
    private List<Long> winLottoMoney;

    public List<Lotto> buy(int fee) {
        this.fee = new Fee(fee);
        int buyCount = this.fee.getBuyCount();

        return buyLotto(buyCount);
    }

    private List<Lotto> buyLotto(int buyCount) {
        this.soldLotto = new ArrayList<>();
        for (int count = 0; count < buyCount; count++) {
            this.soldLotto.add(new Lotto());
        }
        return soldLotto;
    }

    public void initWinNumbers(String winNumbertring) {
        this.winningLottoNumber = new WinningLottoNumber(winNumbertring);
    }

    public List<Long> findWinLottoMoney() {
        this.winLottoMoney = new ArrayList<>();
        for (Lotto lotto : this.soldLotto) {
            findMoney(findIsMatchNumberCount(lotto));
        }
        return this.winLottoMoney;
    }

    private void findMoney(long winNumberCount) {
        Optional<LottoRank> rank = LottoRank.findRank(winNumberCount);
        if (!rank.isPresent()) {
            return;
        }

        this.winLottoMoney.add(rank.get().findMoney());
    }

    private long findIsMatchNumberCount(Lotto lotto) {
        return this.winningLottoNumber.findIsMatchNumberCount(lotto);
    }

    public double findBenefit() {
        long benefitMoney = 0;
        for (Long money : winLottoMoney) {
            benefitMoney += money;
        }

        if (benefitMoney == 0) {
            return ZERO;
        }

        return (double) benefitMoney/fee.getFee();
    }

    public List<Integer> getWinNumbers() {
        return this.winningLottoNumber.getNumbers();
    }
}
