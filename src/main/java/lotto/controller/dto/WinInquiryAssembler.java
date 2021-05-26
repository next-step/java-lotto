package lotto.controller.dto;

import lotto.domain.LottoRank;
import lotto.domain.LottoRanks;

import java.util.ArrayList;
import java.util.List;

public class WinInquiryAssembler {

    public static WinInquiryResponse assembleWinInquiryResponse(LottoRanks lottoRanks) {
        return new WinInquiryResponse(assembleWinStatics(lottoRanks), lottoRanks.totalReturnRate());
    }

    private static List<WinStatistic> assembleWinStatics(LottoRanks lottoRanks) {
        List<WinStatistic> winStatistics = new ArrayList<>();
        for (LottoRank rank : LottoRank.values()) {
            winStatistics.add(new WinStatistic(rank.isMatch(), rank.winAmount(), lottoRanks.count(rank), rank.isMatchBonusTarget()));
        }
        return winStatistics;
    }
}
