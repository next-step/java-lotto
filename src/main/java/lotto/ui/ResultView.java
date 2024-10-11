package lotto.ui;

import lotto.domain.Lotto;
import lotto.dto.LottoMatchInfoDTO;
import lotto.dto.LottoMatchInfosDTO;
import lotto.dto.LottoStatisticsDTO;
import lotto.dto.PurchasedLottosDTO;

import java.util.List;

public class ResultView {
    private static final String LOTTO_STATISTICS_TITLE = "당첨 통계";
    private static final String DASH_LINE = "---------";

    public static void printPurchasedLottos(PurchasedLottosDTO purchasedLottosDTO) {
        List<Lotto> purchasedLottos = purchasedLottosDTO.getPurchasedLottos();
        printPurchasedLottosCount(purchasedLottos);
        printPurchasedLottoNumbers(purchasedLottos);
    }

    private static void printPurchasedLottosCount(List<Lotto> purchasedLottos) {
        System.out.printf("%d개를 구입했습니다.\n", purchasedLottos.size());
    }

    private static void printPurchasedLottoNumbers(List<Lotto> purchasedLottos) {
        for (Lotto purchasedLotto : purchasedLottos) {
            System.out.println(purchasedLotto.getNumbers());
        }
    }

    public static void printLottoStatistics(LottoStatisticsDTO lottoStatistics) {
        addBlankLine();
        printStatisticsTitle();
        addDashLine();
        printMatchInfos(lottoStatistics.getMatchInfosDTO());
        printPercentageRateOfReturn(lottoStatistics.getPercentageRateOfReturn());
    }

    private static void addBlankLine() {
        System.out.println();
    }

    private static void printStatisticsTitle() {
        System.out.println(LOTTO_STATISTICS_TITLE);
    }

    private static void addDashLine() {
        System.out.println(DASH_LINE);
    }

    private static void printMatchInfos(LottoMatchInfosDTO matchInfosDTO) {
        List<LottoMatchInfoDTO> matchInfoDTOs = matchInfosDTO.getMatchInfoDTOs();
        for (LottoMatchInfoDTO matchInfoDTO : matchInfoDTOs) {
            System.out.printf("%d개 일치 (%d원)- %d개\n", matchInfoDTO.getMatchCount(), matchInfoDTO.getReward(), matchInfoDTO.getLottoNum());
        }
    }

    private static void printPercentageRateOfReturn(int percentageRateOfReturn) {
        String percentString = percentageRateOfReturn >= 100 ? "1.00" : String.format("0.%02d", percentageRateOfReturn);
        System.out.printf("총 수익률은 %s입니다.\n", percentString);
    }
}
