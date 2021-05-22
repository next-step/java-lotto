package lotto.controller;

import lotto.controller.dto.LottoNumbersDto;
import lotto.controller.dto.WinInquiryRequest;
import lotto.controller.dto.WinInquiryResponse;
import lotto.controller.dto.WinStatistic;
import lotto.domain.*;
import lotto.service.LottoWinService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoWinController {

    private final LottoWinService lottoWinService;

    public LottoWinController() {
        lottoWinService = new LottoWinService();
    }

    public WinInquiryResponse inquiryWin(WinInquiryRequest request) {
        LottoRanks lottoRanks = lottoWinService.inquiryWin(assemblePurchaseTickets(request.getPurchaseNumbers()), assembleLottoNumbers(request.getWinNumbers()));
        return assembleWinInquiryResponse(lottoRanks);
    }

    private LottoTickets assemblePurchaseTickets(List<LottoNumbersDto> purchaseNumbers) {
        List<LottoTicket> lottoTicketList = purchaseNumbers.stream()
                .map(this::assembleLottoNumbers)
                .collect(Collectors.toList())
                .stream()
                .map(LottoTicket::new)
                .collect(Collectors.toList());
        return new LottoTickets(lottoTicketList);
    }

    private LottoNumbers assembleLottoNumbers(LottoNumbersDto numbers) {
        List<LottoNumber> lottoNumberList = numbers.getLottoNumbers().stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList());
        return new LottoNumbers(lottoNumberList);
    }

    private WinInquiryResponse assembleWinInquiryResponse(LottoRanks lottoRanks) {
        return new WinInquiryResponse(assembleWinStatics(lottoRanks), lottoRanks.totalReturnRate());
    }

    private List<WinStatistic> assembleWinStatics(LottoRanks lottoRanks) {
        List<WinStatistic> winStatistics = new ArrayList<>();
        for (LottoRank rank : LottoRank.values()) {
            winStatistics.add(new WinStatistic(rank.matchCount(), rank.winAmount(), lottoRanks.count(rank)));
        }
        return winStatistics;
    }
}
