package step4.view;

import step4.dto.LottoResultDto;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String LOTTO_PRICE_MESSAGE = "%d개 일치 (%d원)- %d개";
    private static final String LOTTO_STATICS = "구매 통계";
    private static final String LOTTO_BLANKET = "[ %s ]";
    private static final String HYPHEN = "----------";
    private static final String PURCHASE_AMOUNT = "수동으로 %d장 자동으로 %d개를 구매했습니다.";
    private static final String INVEST_RATE = "총 수익률은 %.2f입니다. (기준이 1이기 때문에 결과적으로 %s 라는 의미임)";
    public static final String POSITIVE = "이득";
    public static final String NEGATIVE = "손해";
    public static final int RATE_PERCENT_STANDARD = 1;

    public static final String PURCHASE_MANUAL_LOTTO = "수동으로 구매할 번호를 입력해 주세요.";

    private OutputView() {}


    public static void purchaseManualLotto(){
        println(PURCHASE_MANUAL_LOTTO);
    }
    public static void purchaseLotto(int autoLottoTicketCount, int manualLottoTicketCount) {
        println(printPurchaseLotto(autoLottoTicketCount, manualLottoTicketCount));
    }


    private static String printPurchaseLotto(int autoLottoTicketCount, int manualLottoTicketCount) {
        return String.format(
                PURCHASE_AMOUNT, manualLottoTicketCount, autoLottoTicketCount);
    }

    private static void println(String input) {
        System.out.println(input);
    }

    public static void printLottoTickets(List<String> lottoNumbersListToString) {
        lottoNumbersListToString.forEach(lottoNumbers -> println(String.format(LOTTO_BLANKET, lottoNumbers)));
    }

    public static void printStatics(List<LottoResultDto> lottoResultDtoList) {
        println(LOTTO_STATICS);
        println(HYPHEN);
        println(printLottoPrice(lottoResultDtoList));
    }

    private static String printLottoPrice(List<LottoResultDto> lottoResultDtoList) {
        return lottoResultDtoList.stream()
                .map(lottoResultDto -> String.format(LOTTO_PRICE_MESSAGE,
                        lottoResultDto.getLottoRankMatchCount(),
                        lottoResultDto.getLottoRankPrice(),
                        lottoResultDto.getPrize()))
                .collect(Collectors.joining(System.lineSeparator()));

    }

    public static void printInvestRate(double lottoRate) {

        println(String.format(INVEST_RATE, lottoRate, quantifyInvestLotto(lottoRate)));
    }

    private static String quantifyInvestLotto(double lottoRate) {
        if (lottoRate > RATE_PERCENT_STANDARD) {
            return POSITIVE;
        }
        return NEGATIVE;
    }

}
