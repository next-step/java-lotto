package lotto.view;

import lotto.controller.dto.LottoNumbersDto;
import lotto.controller.dto.LottoPurchaseResponse;
import lotto.controller.dto.WinInquiryResponse;
import lotto.controller.dto.WinStatistic;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public void printPurchaseResult(LottoPurchaseResponse response) {
        System.out.println(response.getLottoNumbersDtoList().size() + "개를 구매했습니다.");
        printLottoNumberList(response.getLottoNumbersDtoList());
    }

    private void printLottoNumberList(List<LottoNumbersDto> lottoNumbersDtoList) {
        for (LottoNumbersDto lottoNumbersDto : lottoNumbersDtoList) {
            System.out.println("[" + printLottoNumbers(lottoNumbersDto) + "]");
        }
    }

    private String printLottoNumbers(LottoNumbersDto lottoNumbersDto) {
        return lottoNumbersDto.getLottoNumbers().stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    public void printWinResult(WinInquiryResponse response) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        printMatchResult(response.getWinStatisticList());
        printTotalReturnRate(response.getTotalReturnRate());
    }

    private void printMatchResult(List<WinStatistic> winStatisticList) {
        for (WinStatistic winStatistic : winStatisticList) {
            printWinStatic(winStatistic);
        }
    }

    private void printWinStatic(WinStatistic winStatistic) {
        if (winStatistic.getRankCount() == 0) {
            return;
        }
        System.out.println(winStatistic.getRankCount() + " 개 일치 (" + winStatistic.getWinAmount() + "원)" + " - " + winStatistic.getMatchCount() + " 개");
    }

    private void printTotalReturnRate(double totalReturnRate) {
        System.out.println("총 수익률은 " + totalReturnRate + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}
