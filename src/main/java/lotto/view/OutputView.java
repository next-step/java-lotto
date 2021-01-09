package lotto.view;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lotto.domain.LottoPrizeType;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.WinnerLottoTicket;

public class OutputView {

    public void printLottoTicket(LottoTickets lotto) {
        printBuyingNumber(lotto.size());
        List<String> lottoTicketString = lotto.getLottoTicketString();
        printLottoTicketsNumber(lottoTicketString);
    }

    public void printLottoResult(WinnerLottoTicket winner, LottoTickets lottoTickets) {
        Map<LottoPrizeType, List<Integer>> resultMap = lottoTickets.checkResult(winner);
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
    }

    private void printBuyingNumber(int size) {
        System.out.printf("%d개를 구매했습니다.%n", size);
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

    private int calculateReward(Map<LottoPrizeType, List<Integer>> resultMap) {
        int reward = 0;
        for (Entry<LottoPrizeType, List<Integer>> entry : resultMap.entrySet()) {
            LottoPrizeType key = entry.getKey();
            reward += key.getPrizeByCount(entry.getValue().size());
        }
        return reward;
    }

    private void printWinnerResult(Map<LottoPrizeType, List<Integer>> resultMap) {
        printWinnerResultTitle();
        for (Entry<LottoPrizeType, List<Integer>> entry : resultMap.entrySet()) {
            LottoPrizeType key = entry.getKey();
            System.out.printf("%d개 일치 (%d원)- %d\n", key.getMatch(), key.getPrize(),
                resultMap.get(key).size());
        }
    }

    private void printWinnerResultTitle() {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
    }
}
