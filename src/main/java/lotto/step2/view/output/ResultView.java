package lotto.step2.view.output;

import lotto.step2.domain.*;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class ResultView {
    private static final String PURCHASED_LOTTO_NUMBER_PRINT_FORM = "%d개를 구매했습니다.\n";
    private static final String WIN_NUMBERS_PRINT_MESSAGE = "\n당첨 통계";
    private static final String BARS = "---------";
    private static final String DECIMAL_FORMAT_PATTERN = "0.##";
    
    public static void purchasedLottoNumbersPrint(LottoTickets lottoTickets, PaymentPrice paymentPrice) {
        System.out.printf(PURCHASED_LOTTO_NUMBER_PRINT_FORM, paymentPrice.numberOfTickets());
        System.out.println(lottoTickets);
        System.out.println();
    }
    
    public static void winsNumbersPrint(WinsNumbers winsNumbers) {
        System.out.println(WIN_NUMBERS_PRINT_MESSAGE);
        System.out.println(BARS);
        System.out.println(winsNumbers);
    }
    
    public static void yieldPrint(double yield) {
        System.out.println("총 수익률은 " + new DecimalFormat(DECIMAL_FORMAT_PATTERN).format(yield) + "입니다.");
    }
}
