package lotto.view;

import lotto.controller.dto.LottoNumbersDto;
import lotto.controller.dto.LottoPurchaseResponse;
import lotto.controller.dto.WinInquiryResponse;
import lotto.controller.dto.WinStatistic;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String BLANK = " ";

    private OutputView() {
        throw new AssertionError();
    }

    public static void printPurchaseResult(LottoPurchaseResponse response) {
        System.out.println(response.getLottoNumbersDtoList().size() + "개를 구매했습니다.");
        printLottoNumberList(response.getLottoNumbersDtoList());
    }

    private static void printLottoNumberList(List<LottoNumbersDto> lottoNumbersDtoList) {
        for (LottoNumbersDto lottoNumbersDto : lottoNumbersDtoList) {
            System.out.println("[" + printLottoNumbers(lottoNumbersDto) + "]");
        }
    }

    private static String printLottoNumbers(LottoNumbersDto lottoNumbersDto) {
        return lottoNumbersDto.getLottoNumbers().stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    public static void printWinResult(WinInquiryResponse response) {
        System.out.println(System.lineSeparator() + "당첨 통계");
        System.out.println("---------");
        printMatchResult(response.getWinStatisticList());
        printTotalReturnRate(response.getTotalReturnRate());
    }

    private static void printMatchResult(List<WinStatistic> winStatisticList) {
        for (WinStatistic winStatistic : winStatisticList) {
            printWinStatic(winStatistic);
        }
    }

    private static void printWinStatic(WinStatistic winStatistic) {
        if (winStatistic.getRankCount() == 0) {
            return;
        }
        System.out.println(winStatistic.getRankCount() + " 개 일치" + printBonusTarget(winStatistic.isMatchBonusTarget()) + "(" + winStatistic.getWinAmount() + "원)" + " - " + winStatistic.getMatchCount() + " 개");
    }

    private static String printBonusTarget(boolean matchBonusTarget) {
        if (matchBonusTarget) {
            return ", 보너스 볼 일치";
        }
        return BLANK;
    }

    private static void printTotalReturnRate(double totalReturnRate) {
        System.out.println("총 수익률은 " + totalReturnRate + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}
