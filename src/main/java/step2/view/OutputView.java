package step2.view;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import step2.domain.LottoNumber;
import step2.domain.PrizeMoney;
import step2.domain.Ticket;

public class OutputView {

    public static void printPriceNotification() {
        System.out.println("구매금액을 입력해 주세요");
    }

    public static void printPurchaseResult(int ticketCount) {
        System.out.println(ticketCount + "개를 구매했습니다.");
    }

    public static void printLottoNumbers(List<LottoNumber> lottoNumbers) {
        for (LottoNumber lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber.getLottoNumbers());
        }
        System.out.println();
    }

    public static void printWinningNumberNotification() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public static void printDrawResult(Map<Integer, Integer> drawLottoResult) {
        System.out.println();
        for (int matchCount : drawLottoResult.keySet()) {
            PrizeMoney prizeMoney = Arrays.stream(PrizeMoney.values())
                .filter(prize -> prize.getMatchCount() == matchCount)
                .findAny()
                .get();
            System.out.println(
                matchCount + "개 일치 (" + prizeMoney.getPrizeMoney() + ")- " + drawLottoResult.get(
                    matchCount));
        }
    }
}
