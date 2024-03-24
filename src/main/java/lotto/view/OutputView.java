package lotto.view;

import lotto.domain.LottoTicket;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;

import java.util.List;

public class OutputView {

    public void printLottoCount(int manualLottoCount, int autoLottoCount) {
        System.out.println("수동으로 " + manualLottoCount + "장, 자동으로 " + autoLottoCount + "장을 구매했습니다.");
    }

    public void printLottoNumbers(LottoTicket lottoTicket) {
        List<String> lottoNumbersToString = lottoTicket.getLottoTicketToString();
        for (String lottoNumberString : lottoNumbersToString) {
            System.out.println(lottoNumberString);
        }
    }

    public void printResult(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("----------");
        for (LottoRank lottoRank : LottoRank.values()) {
            StringBuilder sb = new StringBuilder();
            sb.append(lottoRank.getCorrectCount() + "개 일치");
            if (lottoRank == LottoRank.SECOND) {
                sb.append(", 보너스 볼 일치 ");
            }
            sb.append("(" + lottoRank.getWinnings() + "원) - " + lottoResult.getCorrectCountsByLottoRank(lottoRank) + "개");

            System.out.println(sb);
        }
        System.out.println("총 수익률은 " + lottoResult.rateOfReturn() + "입니다.");
    }
}
