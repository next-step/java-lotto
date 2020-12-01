package step2.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class WinningLottoMoney {
    private static final int ZERO = 0;
    private static final int TWO = 2;

    private final Map<LottoRank, Integer> winningLottoResult = new HashMap<>();

    public WinningLottoMoney(SoldLotto soldLotto, WinningLottoNumber winningLottoNumber) {
        initWinningLottoResult();
        for (Lotto lotto : soldLotto.getSoldLotto()) {
            findMoney(winningLottoNumber.findIsMatchNumberCount(lotto));
        }
    }

    private void initWinningLottoResult() {
        this.winningLottoResult.put(LottoRank.ONE, ZERO);
        this.winningLottoResult.put(LottoRank.TWO, ZERO);
        this.winningLottoResult.put(LottoRank.THREE, ZERO);
        this.winningLottoResult.put(LottoRank.FOUR, ZERO);
    }

    private void findMoney(long winNumberCount) {
        Optional<LottoRank> rank = LottoRank.findRank(winNumberCount);
        if (!rank.isPresent()) {
            return;
        }

        Integer winningCount = this.winningLottoResult.get(rank.get());
        this.winningLottoResult.put(rank.get(), ++winningCount);
    }

    public Map<LottoRank, Integer> getWinningLottoMoney() {
        return this.winningLottoResult;
    }

    public BigDecimal findBenefitByFee(Fee fee) {
        long benefitMoney = 0;
        for (LottoRank rank : LottoRank.values()) {
            benefitMoney += findWinningMoney(rank);
        }

        if (benefitMoney == 0) {
            return BigDecimal.ZERO;
        }

        return new BigDecimal(benefitMoney/fee.getFee()).setScale(TWO, RoundingMode.FLOOR);
    }

    private long findWinningMoney(LottoRank rank) {
        Integer integer = this.getWinningLottoMoney().get(rank);
        return rank.getMoney() * integer;
    }
}
