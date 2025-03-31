package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.Rewards;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public static void printAmount(LottoTicket lottoTicket) {
        System.out.println(lottoTicket.count() + "개를 구매했습니다.");
    }

    public static void printLottoTicket(LottoTicket lottoTicket) {
        lottoTicket.getLottoList().forEach(ResultView::printLotto);
    }

    private static void printLotto(Lotto lotto) {
        List<LottoNumber> numbers = lotto.numbers();
        String lottoNumber = numbers.stream()
                .map(it -> String.valueOf(it.getValue()))
                .collect(Collectors.joining(", "));
        System.out.println("[" + lottoNumber + "]");
    }

    public static void printRewards(Rewards rewards) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원) - " + rewards.fourthPrizeCount() + "개");
        System.out.println("4개 일치 (50000원) - " + rewards.thirdPrizeCount() + "개");
        System.out.println("5개 일치 (1500000원) - " + rewards.secondPrizeCount() + "개");
        System.out.println("6개 일치 (2000000000원) - " + rewards.firstPrizeCount() + "개");
        System.out.println("총 수익률은 " + String.format("%.2f", rewards.winningRate()) + "입니다.");
    }
}
