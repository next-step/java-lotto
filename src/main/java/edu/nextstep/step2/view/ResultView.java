package edu.nextstep.step2.view;

import edu.nextstep.step2.Rank;
import edu.nextstep.step2.domain.LottoNumber;
import edu.nextstep.step2.domain.Lotto;
import edu.nextstep.step2.domain.Money;
import edu.nextstep.step2.domain.Number;

import java.util.*;
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
    private static final String INCOME_MESSAGE_FORMAT = "총 수익률은 %.2f입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public static void printLottoInfo(Lotto lotto) {
        List<String> extractInfos = lotto.getExtractOfLotto().stream()
                .map(extractionNumber -> combineExtractNumber(extractionNumber))
                .collect(Collectors.toList());

        extractInfos.stream()
                .forEach(System.out::println);
    }

    public static void printLotteryCount(Map<Integer, Integer> matchCount) {
        System.out.println("\n당첨 통계\n-------");
        Rank.getRanks().stream()
                .filter(rank -> rank != Rank.ZERO)
                .map(rank -> String.format(MESSAGE_FORMAT, rank.getMatch(), rank.getLotteryMoney(), matchCount.get(rank.getMatch())))
                .forEach(System.out::println);
    }

    public static void printIncome(double income) {
        System.out.println(String.format(INCOME_MESSAGE_FORMAT, income));
    }

    private static String combineExtractNumber(LottoNumber lottoNumber) {
        StringBuilder sb = new StringBuilder();
        sb.append(PREFIX);
        List<Integer> numbers = lottoNumber.stream()
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
