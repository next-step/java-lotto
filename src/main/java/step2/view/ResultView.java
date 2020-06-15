package step2.view;

import step2.domain.LottoTicket;
import step2.domain.enums.WinnerPriceType;

import java.util.Map;

public class ResultView {

    public void showLottos(LottoTicket lottoTicket) {
        lottoTicket.getLottos().forEach(System.out::println);
        System.out.println();
    }

    public void showLottoAmount(int lottoAmount) {
        System.out.println(lottoAmount + "개를 구매했습니다.");
    }

    public void showWinResult(Map<Integer, Integer> lottoWinCount) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (WinnerPriceType priceEnum : WinnerPriceType.values()) {
            System.out.printf("%d개 일치 (%d원)- %d개%n", priceEnum.matchCount, priceEnum.price, lottoWinCount.getOrDefault(priceEnum.matchCount, 0));
        }
    }

    public void showWinRatio(float ratio) {
        System.out.printf("총 수익률은 %s입니다.", String.format("%.2f",ratio));
    }
}
