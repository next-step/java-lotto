package lotto.domain;

import java.util.Arrays;

public class Mock {
    static NumberGroup numberGroups(int number1, int number2, int number3, int number4, int number5, int number6) {
        return new NumberGroup(Arrays.asList(new Number(number1),
                new Number(number2), new Number(number3),
                new Number(number4), new Number(number5), new Number(number6)));
    }

    static Lotto lotto(NumberGroup numberGroup1, NumberGroup numberGroup2, NumberGroup numberGroup3
            , NumberGroup numberGroup4, NumberGroup numberGroup5, NumberGroup numberGroup6) {
        return new Lotto(Arrays.asList(numberGroup1, numberGroup2, numberGroup3, numberGroup4, numberGroup5, numberGroup6));
    }

    static Lotto mockLotto() {
        return lotto(
                //3, 5, 11, 16, 32, 38
                numberGroups(3, 5, 11, 16, 32, 38), // 6
                numberGroups(7, 3, 5, 11, 16, 32), // 5
                numberGroups(3, 7, 5, 11, 16, 8), // 4
                numberGroups(7, 5, 11, 32, 8, 10), // 3
                numberGroups(2, 38, 5, 11, 16, 32), //5
                numberGroups(1, 2, 7, 4, 8, 6) // 0
        );
    }

    static void beforeEach() {
        MatchCriteria.values();
        for (MatchCriteria matchCriteria : MatchCriteria.values()) {
            matchCriteria.initCount();
        }
    }

    static WinningNumbers winningNumbers() {
        String winningNumbers = "1, 2, 3, 4, 5, 6";
        return new WinningNumbers(winningNumbers);
    }
}
