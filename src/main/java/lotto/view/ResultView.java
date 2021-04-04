package lotto.view;

import lotto.controller.dto.LottoTicketPurchaseResponse;
import lotto.controller.dto.WinInquiryResponse;
import lotto.controller.dto.WinStatistic;

import java.util.List;

public class ResultView {
    public void printPurchaseList(LottoTicketPurchaseResponse response) {
        System.out.println("\n수동으로 " + response.getManualPurchaseCount() + "장, 자동으로 " + response.getAutoPurchaseCount() + "장을 구매했습니다.");
        printLottoNumberList(response.getLottoNumberList());
    }

    private void printLottoNumberList(List<String> lottoNumberList) {
        for (String lottoNumbers : lottoNumberList) {
            System.out.println(lottoNumbers);
        }
    }

    public void printLottoWinStatistic(WinInquiryResponse response) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        printWinStatisticList(response.getWinStatisticList());
        printTotalReturnRate(response.getTotalReturnRate());
    }

    private void printWinStatisticList(List<WinStatistic> winStatisticList) {
        for (WinStatistic winStatistic : winStatisticList) {
            System.out.println(winStatistic.getRankCount() + "개 일치" + printMatchBonus(winStatistic.isMatchBonus()) + "(" + winStatistic.getWinAmount() + "원)- " + winStatistic.getMatchLottoCount() + "개");
        }
    }

    private String printMatchBonus(boolean matchBonus) {
        return matchBonus ? ", 보너스 볼 일치" : " ";
    }

    private void printTotalReturnRate(double totalReturnRate) {
        System.out.println("총 수익률은 " + totalReturnRate + "입니다.");
    }
}
