package step2.view;

import step2.domain.LottoTicket;
import step2.domain.enums.WinnerPriceEnum;

import java.util.Map;

public class ResultView {

    public void showLottos(LottoTicket lottoTicket) {
        lottoTicket.getLottoList().forEach(System.out::println);
        System.out.println();
    }

    public void showWinResult(Map<Integer, Integer> lottoWinCount) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (WinnerPriceEnum priceEnum : WinnerPriceEnum.values()) {
            System.out.printf("%d개 일치 (%d원)- %d개%n", priceEnum.matchCount, priceEnum.price, lottoWinCount.getOrDefault(priceEnum.matchCount, 0));
        }
    }

    public void showWinRatio(String ratio) {
        System.out.printf("총 수익률은 %s입니다.", ratio);
    }
}
