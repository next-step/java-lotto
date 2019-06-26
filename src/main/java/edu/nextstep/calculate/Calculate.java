package edu.nextstep.calculate;

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
 * create date  : 2019-06-22 03:02
 */
public class Calculate {

    public static List<Integer> convertToInteger(List<String> convertSource) {
        return convertSource.stream()
                .map(soucreData -> Integer.parseInt(soucreData))
                .collect(Collectors.toList());
    }

    public static int sum(List<Integer> sumTargets) {
        return sumTargets.stream()
                .reduce((integer1, integer2) -> integer1 + integer2)
                .get();
    }
}
