package edu.nextstep.step2;

import java.util.List;
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

    public static void printLottoInfo(Lotto lotto) {
        List<String> extractInfos = lotto.getExtractOfLotto().stream()
                .map(extractionNumber -> combineExtractNumber(extractionNumber))
                .collect(Collectors.toList());

        for (String extractInfo : extractInfos) {
            System.out.println(extractInfo);
        }
    }

    private static String combineExtractNumber(ExtractionNumber exNumber) {
        StringBuilder sb = new StringBuilder();
        sb.append(PREFIX);
        sb.append(exNumber.stream()
                .map(Number::getNumber)
                .map(number -> String.valueOf(number))
                .collect(Collectors.joining(COMMA)));
        sb.append(SUFFIX);
        return sb.toString();
    }
}
