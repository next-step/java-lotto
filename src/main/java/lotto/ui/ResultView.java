package lotto.ui;

import lotto.constant.LottoRank;
import lotto.model.LottoTicket;

import java.util.EnumMap;
import java.util.List;

public class ResultView {

    public static void printLottos(int lottoCount, List<LottoTicket> lottoTicketList) {

        System.out.printf("You got %d lottos\n", lottoCount);
        for (LottoTicket lottoTicket : lottoTicketList) {
            System.out.println(lottoTicket.toString());
        }
    }

    public static void printResult(EnumMap<LottoRank, Integer> gameResult, double rateReturn) {
        System.out.println("Winning statistics\n=========\n");
        for (LottoRank lottoRank : gameResult.keySet()) {
            System.out.println(lottoRank.toString(gameResult.get(lottoRank)));
        }
        System.out.printf("Your rate of return : %f\n", rateReturn);
        String result = "LOST";
        if (rateReturn >= 1) {
            result = "WIN";
        }
        System.out.printf("The standard is 1. you %s\n", result);
    }
}
