package lotto.view;

import java.util.List;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.PrizeAmount;

public class OutputView {

    private static final int LOTTO_SMALLEST_PRIZE_DUPLICATE_COUNT = 3;

    private static final int LOTTO_BIGGEST_PRIZE_DUPLICATE_COUNT = 6;

    public static void numberOfLotto(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void resultStartingPoint() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    public static void winningLottoCounts(LottoResult result) {

        for (int i = LOTTO_SMALLEST_PRIZE_DUPLICATE_COUNT; i <= LOTTO_BIGGEST_PRIZE_DUPLICATE_COUNT; i++) {
            System.out.println(i + "개 일치 (" + PrizeAmount.findPrizeAmount(i) + "원)- " + result.duplicateCount(i) + "개");
        }
    }

    public static void rateOfReturn(float rateOfReturn) {
        System.out.println("총 수익률은 " + String.format("%.2f", rateOfReturn) + "입니다.");
    }

    public static void ticketNumbers(LottoTicket lottoTicket) {
        List<LottoNumbers> allLottoNumbers = lottoTicket.allLottoNumbers();
        for (int i = 0; i < allLottoNumbers.size(); i++) {
            System.out.println(allLottoNumbers.get(i));
        }
    }

}
