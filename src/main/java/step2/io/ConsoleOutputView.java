package step2.io;

import step2.lotto.LottoTickets;
import step2.lottoGame.dto.RankValues;

public class ConsoleOutputView {

    public void printNumberOfPurchases(LottoTickets lottoTickets) {
        lottoTickets.numberOfTickets();
        System.out.printf("%d개를 구매했습니다.%n", lottoTickets.numberOfTickets());
    }

    public void printYield(double yield) {
        if (yield < 1) {
            System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)%n", yield);
            return;
        }

        System.out.printf("총 수익률은 %.2f입니다.%n", yield);
    }

    public void printMatchIndicator(RankValues rankValues) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        rankValues.rankValues()
                .forEach(rankValue -> System.out.printf("%d개 일치 (%d원)- %d개%n", rankValue.numberOfMatchingNumbers(), rankValue.prizeAmount(), rankValue.numberOfWinnings()));
    }

}
