package step2.domain;

import java.math.BigDecimal;
import java.util.*;

public class LottoStore {

    private WinningLottoNumber winningLottoNumber;
    private Fee fee;
    private SoldLotto soldLotto;
    private WinningLottoMoney winningLottoMoney;

    public List<Lotto> buy(int fee, List<List<Integer>> notAutoNumbers) {
        this.fee = Fee.getInstance(fee);
        int autoCount = getAutoCount(notAutoNumbers);
        return buyLotto(autoCount, notAutoNumbers);
    }

    private int getAutoCount(List<List<Integer>> notAutoNumbers) {
        int autoCount = this.fee.getBuyCount() - notAutoNumbers.size();
        if (autoCount < LottoConstant.ZERO) {
            throw new IllegalArgumentException("구입금액이 부족합니다.");
        }
        return autoCount;
    }

    private List<Lotto> buyLotto(int autoCount, List<List<Integer>> notAutoNumbers) {
        this.soldLotto = SoldLotto.of(autoCount, notAutoNumbers);
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

    public List<LottoNo> getWinNumbers() {
        return this.winningLottoNumber.getNumbers();
    }

    public void addBonusNumber(int bonusNumber) {
        this.winningLottoNumber.addBonusNumber(bonusNumber);
    }
}
