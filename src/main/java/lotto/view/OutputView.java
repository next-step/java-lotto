package lotto.view;

import java.util.List;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;

public class OutputView {

    public static void numberOfLotto(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void lottoNumbers(LottoNumbers lottoNumbers) {
        System.out.println(lottoNumbers.toString());
    }

    public static void resultStartingPoint() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    public static void winningLottoCounts(LottoResult result) {
        System.out.println("3개 일치 (5000원)- " + result.duplicateCount(3) + "개");
        System.out.println("4개 일치 (50000원)- " + result.duplicateCount(4) + "개");
        System.out.println("5개 일치 (1500000원)- " + result.duplicateCount(5) + "개");
        System.out.println("6개 일치 (2000000000원)- " + result.duplicateCount(6) + "개");
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
