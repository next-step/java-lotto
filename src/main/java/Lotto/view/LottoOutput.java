package Lotto.view;

import Lotto.model.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoOutput {

    private static final String NOTICE_BUY_LOTTO_MESSAGE = "개를 구매했습니다.";
    private static final String ENTER = "\n";
    private static final String DELIMITER = ", ";
    private static final String LOTTO_RESULT_MESSAGE = "당첨 통계";
    private static final String ASK_MANUAL_LOTTO_NUMBER = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String ASK_LUCKY_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";

    public static void noticeBuyLotto(Lottos lottos, LottoBuyResource lottoBuyResource) {
        List<Lotto> Lottos = lottos.getLottos();
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다" + ENTER, lottoBuyResource.getManualLottoCount(), lottoBuyResource.getAutoLottoCount());
        for (Lotto lotto : Lottos) {
            List<LottoNumber> lottoNumbers = lotto.getLotto();
            System.out.printf("[%s]" + ENTER, lottoNumbers.stream().map(LottoNumber::toString).collect(Collectors.joining(DELIMITER)));
        }
    }

    public static void AskManualLottoNumber() {
        System.out.println(ASK_MANUAL_LOTTO_NUMBER);
    }
    public static void AskLuckyNumber(){
        System.out.println(ASK_LUCKY_NUMBERS);
    }

    public static void printLottoNumber(Lotto lotto) {
        List<LottoNumber> lottoNumbers = lotto.getLotto();
        System.out.printf("%s" + ENTER, lottoNumbers.stream().map(LottoNumber::toString).collect(Collectors.joining(DELIMITER)));
    }

    public static void noticeResult(ResultSummary resultSummary, double profit) {
        System.out.println(LOTTO_RESULT_MESSAGE);
        System.out.println("------------");
        List<Rank> ranks = List.of(Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST);
        for (Rank rank : ranks) {
            System.out.println(convertToString(rank, resultSummary.getCountNumber(rank)));
        }
        System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", profit);
    }

    private static String convertToString(Rank rank, int countNumber) {
        return String.format("%d개 일치 %d원 -%d개", rank.getMatchCount(), rank.getReward(), countNumber);
    }

}
