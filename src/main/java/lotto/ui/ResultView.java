package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.LottoReward;
import lotto.dto.LottoRewardInfoDTO;
import lotto.dto.LottoRewardInfosDTO;
import lotto.dto.LottoStatisticsDTO;
import lotto.dto.PurchasedLottosDTO;

import java.util.ArrayList;
import java.util.Comparator;
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

    private static void printMatchInfos(LottoRewardInfosDTO rewardInfos) {
        List<LottoRewardInfoDTO> rewardInfoDTOs = rewardInfos.getRewardInfoDTOs();
        rewardInfoDTOs.sort(Comparator.comparing((LottoRewardInfoDTO dto) -> dto.getReward().ordinal()).reversed());
        List<LottoRewardInfoDTO> filteredRewardInfoDTOs = filteredRewardInfoDTOs(rewardInfoDTOs);
        for (LottoRewardInfoDTO rewardInfoDTO : filteredRewardInfoDTOs) {
            LottoReward reward = rewardInfoDTO.getReward();
            System.out.printf("%s- %d개\n", reward.getDescription(), rewardInfoDTO.getCount());
        }
    }

    private static List<LottoRewardInfoDTO> filteredRewardInfoDTOs(List<LottoRewardInfoDTO> rewardInfoDTOs) {
        List<LottoRewardInfoDTO> filteredRewardInfoDTOs = new ArrayList<>(rewardInfoDTOs);
        filteredRewardInfoDTOs.removeIf(dto -> dto.getReward().getReward() == 0);
        return filteredRewardInfoDTOs;
    }

    private static void printPercentageRateOfReturn(double percentageRateOfReturn) {
        System.out.printf("총 수익률은 %.2f입니다.\n", percentageRateOfReturn);
    }
}
