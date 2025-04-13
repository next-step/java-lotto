package Lotto.view;

import Lotto.domain.Rank;
import Lotto.domain.Lotto;
import Lotto.domain.Lottos;
import Lotto.domain.ResultStats;

import javax.xml.transform.Result;

public class ConsoleOutputView implements OutputViewInterface {
    @Override
    public void printPrompt(String prompt) {
        System.out.println(prompt);
    }

    @Override
    public void printTicketCount(int manualCount, int autoCount) {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.\n", manualCount, autoCount);
    }

    @Override
    public void printLottos(Lottos lottos) {
        for (Lotto lottoTicket : lottos.getLottos()) {
            System.out.println(lottoTicket.toString());
        }
    }

    private static String getBonusText(Rank prize) {
        if (prize == Rank.SECOND) {
            return ", 보너스 볼 일치";
        }
        return "";
    }

    private static String formatMoney(int amount) {
        return String.format("%,d원", amount);
    }

    private static void printProfit(float profit) {
        System.out.print("총 수익률은 " + formatProfit(profit) + "입니다.");
        if (profit < 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }

    private static String formatProfit(float profit) {
        return String.format("%.2f", profit);
    }
}
