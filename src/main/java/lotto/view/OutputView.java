package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lotto.domain.LottoPrizeType;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.WinnerLottoTicket;

public class OutputView {

    public void printLottoTicket(LottoTickets lottoTickets, Integer inputManualLottoTicketCount) {
        printBuyingCount(lottoTickets.size(), inputManualLottoTicketCount);
        List<String> lottoTicketString = lottoTickets.getLottoTicketString();
        printLottoTicketsNumber(lottoTicketString);
    }

    public void printLottoResult(WinnerLottoTicket winner, LottoTickets lottoTickets) {
        Map<LottoPrizeType, Long> resultMap = lottoTickets.checkResult(winner);
        printWinnerResult(resultMap);
        int reward = calculateReward(resultMap);
        int inputMoney = calculateInputMoney(lottoTickets);
        float yield = calculateYield((float) reward, inputMoney);
        printYieldResult(yield);

    }

    private void printLottoTicketsNumber(List<String> lottoTicketString) {
        lottoTicketString.forEach(this::printLottoTicketNumber);
    }

    private void printLottoTicketNumber(String lottoTicket) {
        System.out.printf("[ %s ]", lottoTicket);
        System.out.println();
    }



    private void printYieldResult(float yield) {
        System.out.printf("총 수익률은 %.2f 입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)", yield, yield > 1 ? "이득" : "손해");
    }

    private float calculateYield(float reward, int inputMoney) {
        return reward / inputMoney;
    }

    private int calculateInputMoney(LottoTickets lottoTickets) {
        return LottoTicket.LOTTO_TICKET_PRICE * lottoTickets.size();
    }

    private int calculateReward(Map<LottoPrizeType, Long> resultMap) {
        int reward = 0;
        for (Entry<LottoPrizeType, Long> entry : resultMap.entrySet()) {
            LottoPrizeType key = entry.getKey();
            reward += key.getPrizeByCount(entry.getValue());
        }
        return reward;
    }

    private void printWinnerResult(Map<LottoPrizeType, Long> resultMap) {
        printWinnerResultTitle();
        Arrays.stream(LottoPrizeType.values())
            .forEach(lottoPrizeType -> printPrizeResult(resultMap, lottoPrizeType));
    }

    private void printPrizeResult(Map<LottoPrizeType, Long> resultMap, LottoPrizeType lottoPrizeType) {
        if (resultMap.containsKey(lottoPrizeType)) {
            printWinningPrizeResult(resultMap, lottoPrizeType);
        } else {
            printLosePrizeResult(lottoPrizeType);
        }
    }

    private void printLosePrizeResult(LottoPrizeType lottoPrizeType) {
        if (LottoPrizeType.TWO_PRIZE.equals(lottoPrizeType)) {
            System.out.printf("%d개 일치, 보너스 볼 일치 (%d원)- 0개\n", lottoPrizeType.getMatch(),
                lottoPrizeType.getPrize());
        } else {
            System.out
                .printf("%d개 일치 (%d원)- 0개\n", lottoPrizeType.getMatch(), lottoPrizeType.getPrize());
        }
    }

    private void printWinningPrizeResult(Map<LottoPrizeType, Long> resultMap, LottoPrizeType lottoPrizeType) {
        if (LottoPrizeType.TWO_PRIZE.equals(lottoPrizeType)) {
            System.out.printf("%d개 일치, 보너스 볼 일치 (%d원)- %d\n", lottoPrizeType.getMatch(),
                lottoPrizeType.getPrize(),
                resultMap.get(lottoPrizeType));
        } else if (LottoPrizeType.NONE.equals(lottoPrizeType)) {
            System.out.printf("꽝- %d\n", resultMap.get(lottoPrizeType));
        } else {
            System.out
                .printf("%d개 일치 (%d원)- %d개\n", lottoPrizeType.getMatch(), lottoPrizeType.getPrize(),
                    resultMap.get(lottoPrizeType));
        }
    }

    private void printWinnerResultTitle() {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
    }

    public void printBuyingCount(int ticketCount, int manualTicketCount) {
        System.out
            .printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.\n", manualTicketCount, ticketCount - manualTicketCount);
    }
}
