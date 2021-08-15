package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoTicket;

public class OutputView {

    public void printOpening() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printGameNum(int gameNum) {
        System.out.println(gameNum + "개를 구매했습니다.");
    }

    public void printTickets(Lotto lotto) {
        List<LottoTicket> lottoTickets = lotto.getTickets();
        for (LottoTicket lottoTicket : lottoTickets) {
            System.out.println(lottoTicket.getLottoNumbers());
        }
        System.out.println();
    }

    public void printLastWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public void printResult(Map<LottoRank, Integer> result) {
        System.out.println("당첨 통계\n" + "---------");
        System.out.println("3개 일치 (5000원)- " + result.get(LottoRank.FOURTH) + "개");
        System.out.println("4개 일치 (50000원)- " + result.get(LottoRank.THIRD) + "개");
        System.out.println("5개 일치 (1500000원)- " + result.get(LottoRank.SECOND) + "개");
        System.out.println("6개 일치 (2000000000원)- " + result.get(LottoRank.FIRST) + "개");
    }

    public void printProfitValue(Double profitValue) {
        System.out.println("총 수익률은" + profitValue + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}
