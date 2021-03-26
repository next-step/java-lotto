package lotto.controller;

import lotto.controller.dto.*;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoRanks;
import lotto.domain.LottoTicket;
import lotto.service.LottoAutoService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoController {

    private final LottoAutoService lottoAutoService;

    public LottoController() {
        this.lottoAutoService = new LottoAutoService();
    }

    public LottoAutoPurchaseResponse purchaseLottoAutoTicket(LottoAutoPurchaseRequest request) {
        LottoTicket lottoTicket = lottoAutoService.purchaseLottoTicket(request.getPurchaseAmount());
        return new LottoAutoPurchaseResponse(lottoTicket.getCount(), assembleLottoNumbers(lottoTicket.getLottoList()));
    }

    private List<String> assembleLottoNumbers(List<Lotto> lottoList) {
        return lottoList.stream().map(lotto -> Arrays.toString(lotto.getLottoNumbers())).collect(Collectors.toList());
    }

    public WinInquiryResponse inquiryWin(WinInquiryRequest request) {
        LottoRanks lottoRanks = lottoAutoService.inquiryWin(request.getConfirmTargetList(), generateWinNumber(request.getWinNumber()));
        return assembleWinResult(lottoRanks);
    }

    private int[] generateWinNumber(String winNumber) {
        return Arrays.stream(winNumber.split(",")).mapToInt(value -> Integer.parseInt(value.trim())).toArray();
    }

    private WinInquiryResponse assembleWinResult(LottoRanks lottoRanks) {
        return new WinInquiryResponse(lottoRanks.totalReturnRate(), assembleWinStatistics(lottoRanks));
    }

    private List<WinStatistic> assembleWinStatistics(LottoRanks lottoRanks) {
        List<WinStatistic> winStatisticList = new ArrayList<>();
        for (LottoRank lottoRank : LottoRank.values()) {
            winStatisticList.add(new WinStatistic(lottoRank.getMatchCount(), lottoRank.getWinAmount(), lottoRanks.matchLottoCount(lottoRank)));
        }
        return winStatisticList.stream().filter(winStatistic -> winStatistic.getRankCount() > LottoRank.LOSE.getMatchCount()).collect(Collectors.toList());
    }
}
