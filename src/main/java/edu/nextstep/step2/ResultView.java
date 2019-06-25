package edu.nextstep.step2;

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
    private static final String MESSAGE_FORMAT = "%d개 일치 (%d월)- %d개";
    private static final String INCOME_MESSAGE_FORMAT = "총 수익률은 %.2f입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public static void printLottoInfo(Lotto lotto) {
        List<String> extractInfos = lotto.getExtractOfLotto().stream()
                .map(extractionNumber -> combineExtractNumber(extractionNumber))
                .collect(Collectors.toList());

        for (String extractInfo : extractInfos) {
            System.out.println(extractInfo);
        }
    }

    public static void printResult(List<Integer> matchCount, Money money) {
        System.out.println("\n당첨 통계\n-------");
        procOperatorCount(getMatchCount(matchCount), money);
    }

    private static void procOperatorCount(List<Integer> operator, Money money) {
        Map<Integer, Integer> count = convertListToMap(operator);
        List<Operator> operators = Operator.getOperators();

        int totalIncome = 0;
        for (Operator oper : operators) {
            totalIncome += printStaticResult(oper, count);
        }

        double percentIncome = (double) totalIncome / (double) money.getInputMoney();
        System.out.println(String.format(INCOME_MESSAGE_FORMAT, percentIncome));
    }

    private static List<Integer> getMatchCount(List<Integer> matchCount) {
        return matchCount.stream()
                .peek(count -> Operator.matchCheck(count))
                .collect(Collectors.toList());
    }

    private static int printStaticResult(Operator operator, Map<Integer, Integer> count) {
        int operatorLotteryNumber = operator.getMatch();
        int matchCount = 0;

        if (count.containsKey(operatorLotteryNumber)) {
            matchCount = count.get(operatorLotteryNumber);
        }

        Operator oper = Operator.matchCheck(operatorLotteryNumber);
        System.out.println(String.format(MESSAGE_FORMAT, operatorLotteryNumber, oper.getLotteryMoney(), matchCount));

        return matchCount * Operator.matchCheck(operatorLotteryNumber).getLotteryMoney();
    }

    private static Map<Integer, Integer> convertListToMap(List<Integer> operator) {
        Map<Integer, Integer> countMap = new HashMap<>();
        operator.forEach(e -> {
            Integer count = countMap.get(e);
            countMap.put(e, count == null ? 1 : count + 1);
        });
        return countMap;
    }

    private static String combineExtractNumber(ExtractionNumber exNumber) {
        StringBuilder sb = new StringBuilder();
        sb.append(PREFIX);
        List<Integer> numbers = exNumber.stream()
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
