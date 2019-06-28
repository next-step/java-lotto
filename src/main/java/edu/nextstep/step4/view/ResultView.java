package edu.nextstep.step4.view;

import edu.nextstep.step4.domain.WinInfo;
import edu.nextstep.step4.enums.Rank;
import edu.nextstep.step4.domain.Lottos;
import edu.nextstep.step4.domain.Lotto;
import edu.nextstep.step4.domain.Number;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-lotto
 * create date  : 2019-06-25 01:14
 */
public class ResultView {
    private static final String PREFIX = "[";
    private static final String COMMA = ",";
    private static final String SUFFIX = "]";
    private static final String MESSAGE_FORMAT = "%d개 일치 (%d원)- %d개";
    private static final String BONUS_MESSAGE_FORMAT = "%d개 일치, 보너스 볼 일치 (%d원)- %d개";
    private static final String INCOME_MESSAGE_FORMAT = "총 수익률은 %.2f입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public static void printLottoInfo(Lottos lottos) {
        List<String> extractInfos = lottos.getExtractOfLotto().stream()
                .map(extractionNumber -> combineExtractNumber(extractionNumber))
                .collect(Collectors.toList());

        extractInfos.stream()
                .forEach(System.out::println);
    }

    public static void printIncome(double income) {
        System.out.println(String.format(INCOME_MESSAGE_FORMAT, income));
    }

    public static void printLotteryCount(WinInfo lotteryInfo) {
        System.out.println("\n당첨 통계\n-------");
        Arrays.stream(Rank.values())
                .filter(ranks -> ranks != Rank.ZERO)
                .map(ranks ->
                        combineLotteryResultMessage(ranks.getMatch(), ranks.getLotteryMoney(), Rank.matchOfCount(lotteryInfo, ranks), ranks.getBonusRank())
                ).forEach(System.out::println);
    }

    private static String combineLotteryResultMessage(int count, int money, int matchCount, boolean bonus) {
        if (bonus) {
            return String.format(BONUS_MESSAGE_FORMAT, count, money, matchCount);
        }
        return String.format(MESSAGE_FORMAT, count, money, matchCount);
    }

    private static String combineExtractNumber(Lotto lotto) {
        StringBuilder sb = new StringBuilder();
        sb.append(PREFIX);
        List<Integer> numbers = lotto.stream()
                .map(Number::getNumber)
                .collect(Collectors.toList());

        Collections.sort(numbers);

        sb.append(numbers.stream()
                .map(number -> String.valueOf(number))
                .collect(Collectors.joining(COMMA)));
        sb.append(SUFFIX);
        return sb.toString();
    }
}
