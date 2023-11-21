package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.MatchInfo;
import lotto.domain.MyLotto;
import lotto.domain.PrizeResult;

import java.util.Comparator;
import java.util.List;

public class ResultView {
    private static final String OUTPUT_MESSAGE_OF_PURCHASE_AMOUNT = "개를 구매했습니다.";
    private static final String OUTPUT_MESSAGE_OF_RESULT_START = "당첨 통계\n---------";
    private static final String OUTPUT_FORMAT_OF_MATCHING = "%d개 일치 (%d원)- %d개\n";
    private static final String OUTPUT_FORMAT_OF_RATE = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public static void printMyLottoList(MyLotto myLotto){
        List<Lotto> lottoList = myLotto.getLottoList();
        printAmount(lottoList.size());
        for(Lotto lotto : lottoList){
            System.out.println(lotto.getLottoNumberList());
        }
        System.out.println();
    }

    private static void printAmount(int amount){
        StringBuilder builder = new StringBuilder();
        builder.append(amount);
        builder.append(OUTPUT_MESSAGE_OF_PURCHASE_AMOUNT);
        System.out.println(builder);
    }

    public static void printLottoResult(PrizeResult prizeResult){
        System.out.println(OUTPUT_MESSAGE_OF_RESULT_START);
        prizeResult.getPrizeResultInfoList().entrySet()
                .stream()
                .filter(matchInfoIntegerEntry -> !matchInfoIntegerEntry.getKey().equals(MatchInfo.OTHERS))
                .sorted(Comparator.comparing(matchInfoIntegerEntry -> matchInfoIntegerEntry.getKey().getCount()))
                .forEach(matchInfoIntegerEntry -> printMatchResult(matchInfoIntegerEntry.getKey(), matchInfoIntegerEntry.getValue()));
    }

    private static void printMatchResult(MatchInfo matchInfo, Integer matchCount){
        System.out.printf(OUTPUT_FORMAT_OF_MATCHING, matchInfo.getCount(), matchInfo.getReward(), matchCount);
    }

    public static void printEarnRate(PrizeResult prizeResult, int inputMoney){
        System.out.printf(OUTPUT_FORMAT_OF_RATE, prizeResult.getEarnRate(inputMoney));
    }
}
