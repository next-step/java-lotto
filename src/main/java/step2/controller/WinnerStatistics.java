package step2.controller;

import step2.util.Cast;

import java.util.List;

public class WinnerStatistics {
    private static final int MATCH3_COUNT = 3;
    private static final int MATCH4_COUNT = 4;
    private static final int MATCH5_COUNT = 5;
    private static final int MATCH6_COUNT = 6;

    public static int[] result(List<List> lottos, String winningNumber) {
        int[] numbers = Cast.castToNumber(winningNumber);

        int match3 = 0;
        int match4 = 0;
        int match5 = 0;
        int match6 = 0;

        int count = 0;

        for(int i = 0; i < lottos.size(); i++) {
            count = count(lottos.get(i), numbers);
            match3 = (count == MATCH3_COUNT) ? match3 + 1 : match3;
            match4 = (count == MATCH4_COUNT) ? match4 + 1 : match4;
            match5 = (count == MATCH5_COUNT) ? match5 + 1 : match5;
            match6 = (count == MATCH6_COUNT) ? match6 + 1 : match6;
            count = 0;
        }
        int[] result = {match3, match4, match5, match6};
        return result;
    }

    private static int count(List list, int[] numbers) {
        int count = 0;
        for(int i = 0; i < numbers.length; i++) {
            count = list.contains(numbers[i]) ? (count + 1) : count;
        }
        return count;
    }

}
