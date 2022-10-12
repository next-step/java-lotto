package lotto.step2.view.output;

import lotto.step2.domain.*;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String WINS_SECOND_PRINT_FORMAT = "%d개 일치, 보너스 볼 일치 (%d원) - %d개";
    private static final String WINS_NUMBERS_PRINT_FORMAT = "%d개 일치 (%d원) - %d개";
    private static final String PURCHASED_LOTTO_NUMBER_PRINT_FORM = "%d개를 구매했습니다.\n";
    private static final String YIELD_PRINT_FORMAT = "총 수익률은 %s입니다.";
    private static final String WIN_NUMBERS_PRINT_MESSAGE = "\n당첨 통계";
    private static final String BARS = "---------";
    private static final String DECIMAL_FORMAT_PATTERN = "0.##";
    private static final String NEW_LINE = "\n";
    
    public static void purchasedLottoNumbersPrint(LottoTickets lottoTickets, PaymentPrice paymentPrice) {
        System.out.printf(PURCHASED_LOTTO_NUMBER_PRINT_FORM, paymentPrice.countOfAutoLotto());
        lottoTickets.getLottoTickets().stream()
                .map(ResultView::lottoTicketPrintFormat)
                .forEach(System.out::println);
        System.out.println();
    }
    
    private static String lottoTicketPrintFormat(LottoTicket lottoTicket) {
        return lottoTicket.getLottoTicket().stream()
                .map(LottoNumber::getLottoNumber)
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }
    
    public static void winsNumbersPrint(List<LottoRank> lottoRanks) {
        System.out.println(WIN_NUMBERS_PRINT_MESSAGE);
        System.out.println(BARS);
        System.out.println(getWinsNumbers(lottoRanks));
    }
    
    private static String getWinsNumbers(List<LottoRank> lottoRanks) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank != LottoRank.MISS)
                .map(lottoRank -> winsNumbersPrintFormat(lottoRanks, lottoRank))
                .collect(Collectors.joining(NEW_LINE));
    }
    
    private static String winsNumbersPrintFormat(List<LottoRank> lottoRanks, LottoRank lottoRank) {
        if (lottoRank == LottoRank.SECOND) {
            return String.format(WINS_SECOND_PRINT_FORMAT, lottoRank.getCountOfMatchNumber(), lottoRank.getReward(), lottoRank.getCountOfLottoRanks(lottoRanks));
        }
        return String.format(WINS_NUMBERS_PRINT_FORMAT, lottoRank.getCountOfMatchNumber(), lottoRank.getReward(), lottoRank.getCountOfLottoRanks(lottoRanks));
    }
    
    public static void yieldPrint(double yield) {
        System.out.printf(YIELD_PRINT_FORMAT, new DecimalFormat(DECIMAL_FORMAT_PATTERN).format(yield));
    }
}
