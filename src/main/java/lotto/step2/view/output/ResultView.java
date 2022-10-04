package lotto.step2.view.output;

import lotto.step2.domain.*;
import lotto.step2.dto.LottoNumberDTO;
import lotto.step2.dto.LottoTicketDTO;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String WINS_NUMBERS_PRINT_FORMAT = "%d개 일치 (%d) - %d개";
    private static final String PURCHASED_LOTTO_NUMBER_PRINT_FORM = "%d개를 구매했습니다.\n";
    private static final String YIELD_PRINT_FORMAT = "총 수익률은 %s입니다.";
    private static final String WIN_NUMBERS_PRINT_MESSAGE = "\n당첨 통계";
    private static final String BARS = "---------";
    private static final String DECIMAL_FORMAT_PATTERN = "0.##";
    
    public static void purchasedLottoNumbersPrint(LottoTickets lottoTickets, PaymentPrice paymentPrice) {
        System.out.printf(PURCHASED_LOTTO_NUMBER_PRINT_FORM, paymentPrice.numberOfTickets());
        lottoTickets.lottoTicketsInformation().getLottoTickets().stream()
                .map(LottoTicket::lottoTicketInformation)
                .map(ResultView::lottoTicketPrintFormat)
                .forEach(System.out::println);
        System.out.println();
    }
    
    private static String lottoTicketPrintFormat(LottoTicketDTO lottoTicketDTO) {
        return lottoTicketDTO.getLottoTicket().stream()
                .map(LottoNumber::lottoNumberInformation)
                .map(LottoNumberDTO::getLottoNumber)
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
                .map(lottoRank -> String.format(WINS_NUMBERS_PRINT_FORMAT, lottoRank.getCountOfMatchNumber(), lottoRank.getReward(), lottoRank.getCountOfLottoRanks(lottoRanks)))
                .collect(Collectors.joining("\n"));
    }
    
    public static void yieldPrint(double yield) {
        System.out.printf(YIELD_PRINT_FORMAT, new DecimalFormat(DECIMAL_FORMAT_PATTERN).format(yield));
    }
}
