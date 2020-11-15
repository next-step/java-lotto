package step2.view;

import step2.domain.LottoRank;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OutputView {

    private static final String LOTTO_PRICE_MESSAGE = "%d개 일치 (%d원)- %d개";
    private static final String LOTTO_STATICS = "구매 통계";
    private static final String LOTTO_BLANKET = "[ %s ]";
    private static final String HYPHEN = "----------";
    private static final String PURCHASE_AMOUNT = "개를 구매했습니다.";
    private static final String INVEST_RATE = "총 수익률은 %.2f입니다. (기준이 1이기 때문에 결과적으로 %s 라는 의미임)";

    private OutputView() {
    }

    public static void purchaseLotto(int lottoTicketCount) {
        println(printPurchaseLotto(lottoTicketCount));
    }

    private static String printPurchaseLotto(int lottoTicketCount) {
        return String.format(
                String.valueOf(lottoTicketCount), PURCHASE_AMOUNT);
    }

    private static void println(String input) {
        System.out.println(input);
    }

    public static void printLottoTickets(List<String> lottoNumbersListToString) {
        lottoNumbersListToString.forEach(lottoNumbers -> println(String.format(LOTTO_BLANKET, lottoNumbers)));
    }

    public static void printStatics(Map<LottoRank, Integer> result) {
        println(LOTTO_STATICS);
        println(HYPHEN);
        println(printLottoPrice(result));
    }

    private static String printLottoPrice(Map<LottoRank, Integer> result) {
        return Stream.of(LottoRank.FIRST, LottoRank.SECOND, LottoRank.THIRD, LottoRank.FORTH)
                .map(lottoRank -> String.format(LOTTO_PRICE_MESSAGE, lottoRank.getMatch(), lottoRank.getPrice(), result.get(lottoRank)))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    public static void printInvestRate(double lottoRate){

        println(String.format(INVEST_RATE , lottoRate , quantifyInvestLotto(lottoRate)));
    }
    private static String quantifyInvestLotto(double lottoRate){
        if(lottoRate > 1){
            return "이득";
        }
        return "손해";
    }

}
