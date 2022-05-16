package lotto.domain;

public class WinningMoneyCalculator {

    static final int FIRST_RANK_MONEY = 2000000000;
    static final int SECOND_RANK_MONEY = 1500000;
    static final int THIRD_RANK_MONEY = 50000;
    static final int FOURTH_RANK_MONEY = 5000;
    static final int DROP_MONEY = 0;

    public static int getTotalWinningMoney(Lotto winningLotto, Lottos buyingLottos) {
        int totalWinningMoney = 0;
        for (Lotto buyingLotto : buyingLottos.getLottoList()) {
            totalWinningMoney += getMoneyWithRank(buyingLotto.getRank(winningLotto));
        }
        return totalWinningMoney;
    }

    private static int getMoneyWithRank(int rank) {
        switch (rank) {
            case 1:
                return FIRST_RANK_MONEY;
            case 2:
                return SECOND_RANK_MONEY;
            case 3:
                return THIRD_RANK_MONEY;
            case 4:
                return FOURTH_RANK_MONEY;
            default:
                return DROP_MONEY;
        }
    }
}

