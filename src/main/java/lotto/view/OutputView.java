package lotto.view;

import lotto.domain.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String NUMBER_OF_PURCHASE = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";
    private static final String WINNING_STATICS = "당첨 통계";
    private static final String DIVIDING_LINE = "---------";
    private static final String WINNING_STATICS_FORMAT = "%d개 일치 (%d원)- %d개";
    private static final String SECOND_WINNING_STATICS_FORMAT = "%d개 일치, 보너스 볼 일치 (%d원)- %d개";
    private static final String EARNING_RATE_LESSTHAN_1_FORMAT = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final String EARNING_RATE_FORMAT = "총 수익률은 %.2f입니다.";

    private OutputView() {
    }

    public static void printNumberOfPurchase(LottoPurchaseInformation lottoPurchaseInformation) {
        int numberOfManuallyPickedLottoTicket = lottoPurchaseInformation.numberOfManuallyPickedLottoTicket();
        int numberOfAutomaticallyPickedLottoTicket = lottoPurchaseInformation.numberOfAutomaticallyPickedLottoTicket();

        String formattedString = String.format(NUMBER_OF_PURCHASE, numberOfManuallyPickedLottoTicket, numberOfAutomaticallyPickedLottoTicket);
        System.out.println(formattedString);
    }

    public static void printLottoNumbers(List<LottoNumber> numbers) {
        System.out.println(numbers);
    }

    public static void printLottoNumbers(LottoTickets lottoTickets) {
        List<LottoTicket> lottoTicketList = lottoTickets.getLottoTickets();
        for (LottoTicket lottoTicket : lottoTicketList) {
            OutputView.printLottoNumbers(lottoTicket.getLottoNumbers());
        }
    }

    public static void printWinningStatics(Map<LottoRank, Integer> map) {
        System.out.println(WINNING_STATICS);
        System.out.println(DIVIDING_LINE);
        List<LottoRank> lottoRankList = Arrays.asList(LottoRank.FIRST, LottoRank.SECOND, LottoRank.THIRD, LottoRank.FOURTH, LottoRank.FIFTH);
        for (LottoRank lottoRank : lottoRankList) {
            String format = getWinningStaticsFormat(lottoRank);
            String formattedString = String.format(format, lottoRank.countOfMatch(), lottoRank.winningPrize(), map.get(lottoRank));
            System.out.println(formattedString);
        }

        System.out.println();
    }

    private static String getWinningStaticsFormat(LottoRank lottoRank) {
        if (lottoRank == LottoRank.SECOND) {
            return SECOND_WINNING_STATICS_FORMAT;
        }
        return WINNING_STATICS_FORMAT;
    }

    public static void earningRate(double rate) {
        String format = String.format(gerEarningRateFormat(rate), rate);
        System.out.println(format);
    }

    private static String gerEarningRateFormat(double rate) {
        if (rate < 1) {
            return EARNING_RATE_LESSTHAN_1_FORMAT;
        }
        return EARNING_RATE_FORMAT;
    }

}
