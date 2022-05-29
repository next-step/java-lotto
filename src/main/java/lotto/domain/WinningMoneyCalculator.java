package lotto.domain;

public class WinningMoneyCalculator {


    private WinningMoneyCalculator() {
    }

    public static int getTotalWinningMoney(WinningLotto winningLotto, Lottos buyingLottos) {
        int totalWinningMoney = 0;
        for (Lotto buyingLotto : buyingLottos.getLottoList()) {
            totalWinningMoney += buyingLotto.getRank(winningLotto).getWinningMoney();
        }
        return totalWinningMoney;
    }

}

