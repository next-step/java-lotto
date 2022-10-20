package lotto.view;

import lotto.domain.LottoAmount;
import lotto.domain.LottoPrize;
import lotto.domain.LottoWinning;
import lotto.dto.LottoDto;

import java.util.List;

public class ResultView {

    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String WINNING_STATISTICS_MESSAGE = LINE_SEPARATOR + "당첨 통계";

    private ResultView() {
    }

    public static void showLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void showAutoLottoTicket(List<LottoDto> lottos) {
        for (LottoDto lotto : lottos) {
            System.out.println(lotto.getNumbers().toString());
        }
        System.out.println(System.lineSeparator());
    }

    public static void printWinning(LottoWinning winning) {
        System.out.println(WINNING_STATISTICS_MESSAGE);
        System.out.println("----------");
        winning.getWinning().forEach((key, value) -> {
            if (key != LottoPrize.NOT_SAME) {
                System.out.println(key.getMatch() + "개 일치 (" + key.getMoney() + "원) - " + value + "개");
            }
        });
        System.out.println("===================");
    }

    public static void printWinningRate(LottoWinning winning, LottoAmount lottoAmount) {
        double sum = winning.sumPrizeMoney();
        double rate = sum / lottoAmount.getAmount();
        System.out.printf("총 수익률은 %.2f 입니다. (기준은 1입니다. 1보다 크면 이득, 1보다 작으면 손해)", rate);
    }
}
