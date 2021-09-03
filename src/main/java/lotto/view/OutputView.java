package lotto.view;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import lotto.domain.LottoGame;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoRank;
import lotto.domain.LottoTicket;

public class OutputView {

    public void printBasicInfo(LottoGame lottoGame) {
        printGameSize(lottoGame.size());
        printTickets(lottoGame.getLottoTicket());
    }

    public void printGameSize(int gameSize) {
        System.out.println(gameSize + "개를 구매했습니다.");
    }

    public void printTickets(LottoTicket lottoTicket) {
        List<LottoNumbers> lottoTickets = lottoTicket.getTickets();
        for (LottoNumbers lottoNumbers : lottoTickets) {
            System.out.println(lottoNumbers.makeLottoNumbersStringList());
        }
        System.out.println();
    }

    public void printResult(Map<LottoRank, Integer> result) {
        System.out.println("당첨 통계\n" + "---------");
        Arrays.stream(LottoRank.values())
              .sorted(Comparator.comparing(LottoRank::getPrice))
              .filter(value -> value.getCollectNumber() > 0)
              .forEach(value -> System.out.printf("%d개 일치 (%d원)- %d개%n",
                                                  value.getCollectNumber(),
                                                  value.getPrice(),
                                                  result.getOrDefault(value,0)));
    }

    public void printProfitRatio(Double profitRatio) {
        System.out.printf("총 수익률은 %.2f 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)%n", profitRatio);
    }
}
