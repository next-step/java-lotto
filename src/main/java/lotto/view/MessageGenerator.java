package lotto.view;

import lotto.domain.WinningGrade;

public class MessageGenerator {
    public static String generate(WinningGrade winningResult) {

        String additionalMessage = "";

        if(winningResult.isSecond()){
            additionalMessage = ", 보너스 볼 일치";
        }

        return String.format("%d개 일치%s(%d원) - %d개", winningResult.getMatchingCount(), additionalMessage
                , winningResult.getWinningPrice(), winningResult.getCount());
    }
}
