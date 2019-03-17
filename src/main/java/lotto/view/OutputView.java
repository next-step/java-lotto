package lotto.view;

import lotto.domain.LottoGame;
import lotto.domain.lotto.BasicLotto;
import lotto.enums.Rank;

import java.util.List;

public class OutputView {
    private static int threeMatchCount = 0;
    private static int fourMatchCount = 0;
    private static int fiveMatchCount = 0;
    private static int sixMatchCount = 0;

    public static void generateResult(List<BasicLotto> lottos) {
        for (BasicLotto lotto : lottos) {
            if (lotto.getMatchCount() == Rank.FOURCE.getCountOfMatch()) {
                threeMatchCount++;
            }
            if (lotto.getMatchCount() == Rank.THIRD.getCountOfMatch()) {
                fourMatchCount++;
            }
            if (lotto.getMatchCount() == Rank.SECOND.getCountOfMatch()) {
                fiveMatchCount++;
            }
            if (lotto.getMatchCount() == Rank.FIRST.getCountOfMatch()) {
                sixMatchCount++;
            }
        }
    }

    public static String getRewardPercent(int money) {
        int reward = 0;

        reward += (Rank.FOURCE.getWinningMoney() * threeMatchCount);
        reward += (Rank.THIRD.getWinningMoney() * fourMatchCount);
        reward += (Rank.SECOND.getWinningMoney() * fiveMatchCount);
        reward += (Rank.FIRST.getWinningMoney() * sixMatchCount);

        double percent = (double) reward / money;
        return String.format("%.2f", percent);
    }

    public static int getThreeMatchCount() {
        return threeMatchCount;
    }

    public static int getFourMatchCount() {
        return fourMatchCount;
    }

    public static int getFiveMatchCount() {
        return fiveMatchCount;
    }

    public static int getSixMatchCount() {
        return sixMatchCount;
    }
}
