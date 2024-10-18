package lotto.domain;

import java.math.BigDecimal;

public enum LottoRankEnum {

    FIRST(new BigDecimal(2000000000), 6, "6개 일치 (2000000000원)- ") {
        @Override
        public Boolean isMatch(WinningLotto winningLotto, Lotto userLotto) {
            return winningLotto.getWinningLotto().equals(userLotto);
        }

    },
    SECOND(new BigDecimal(30000000), 5, "5개 일치 , 보너스 볼 일치(30000000원)- ") {
        @Override
        public Boolean isMatch(WinningLotto winningLotto, Lotto userLotto) {
            if (userLotto.getMatchCount(winningLotto.getWinningLotto()) != getMatchCnt()) {
                return false;
            }
            return userLotto.contains(winningLotto.getBonusLottoNumber());
        }
    },
    THIRD(new BigDecimal(15000000), 5, "5개 일치 (15000000원)- ") {
        @Override
        public Boolean isMatch(WinningLotto winningLotto, Lotto userLotto) {
            return winningLotto.getWinningLotto().getMatchCount(userLotto) == getMatchCnt();
        }

    },
    FOURTH(new BigDecimal(50000), 4, "4개 일치 (50000원)- ") {
        @Override
        public Boolean isMatch(WinningLotto winningLotto, Lotto userLotto) {
            return winningLotto.getWinningLotto().getMatchCount(userLotto) == getMatchCnt();
        }

    },
    FIVE(new BigDecimal(5000), 3, "3개 일치 (5000)- ") {
        @Override
        public Boolean isMatch(WinningLotto winningLotto, Lotto userLotto) {
            return winningLotto.getWinningLotto().getMatchCount(userLotto) == getMatchCnt();
        }

    },
    LOSING_LOT(BigDecimal.ZERO, 2, "") {
        @Override
        public Boolean isMatch(WinningLotto winningLotto, Lotto userLotto) {
            return winningLotto.getWinningLotto().getMatchCount(userLotto) <= getMatchCnt();
        }

    };


    private BigDecimal winningAmount;
    private int matchCnt;
    private String description;

    private LottoRankEnum(BigDecimal winningAmount, int matchCnt, String description) {
        this.winningAmount = winningAmount;
        this.matchCnt = matchCnt;
        this.description = description;
    }

    public abstract Boolean isMatch(WinningLotto winningLotto, Lotto lotto);

    public int getMatchCnt() {
        return matchCnt;
    }

    public BigDecimal getWinningAmount() {
        return winningAmount;
    }

    public String getDescription() {
        return description;
    }
}
