package edu.nextstep.lotto.step1;

import edu.nextstep.lotto.step1.domain.DefaultDelimiterSplitter;
import edu.nextstep.lotto.step1.domain.DefaultSumCalculator;
import edu.nextstep.lotto.step1.domain.DelimiterSplitter;
import edu.nextstep.lotto.step1.domain.SumCalculator;

public class StringAddCalculator {

    private static final DelimiterSplitter splitter = new DefaultDelimiterSplitter();
    private static final SumCalculator calculator = new DefaultSumCalculator();

    public static int splitAndSum(String text) {
        return isEmpty(text) ? 0 : calculator.sum(splitter.split(text));
    }

    private static boolean isEmpty(String text) {
        return text == null || text.isEmpty();
    }
}
