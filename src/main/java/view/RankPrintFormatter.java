package view;

import domain.Rank;

public class RankPrintFormatter {
    public static String format(Rank rank) {

        String bonusFormat = "";

        if (rank.needMatchBonus()) {
            bonusFormat = ", 보너스 볼 일치";
        }

        return String.format("%s개 일치%s (%s원)",
                rank.getCountOfMatch(), bonusFormat, rank.getWinningMoney());
    }
}
