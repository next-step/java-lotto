package step2.controller;

import step2.util.Cast;

import java.util.List;

public enum Rank {
    MATCH3(3),
    MATCH4(4),
    MATCH5(5),
    MATCH6(6);

    private static int[] result = {0, 0, 0, 0};
    private final int count;

    Rank(int count) {
        this.count = count;
    }

    public static int[] result(List<List<int[]>> lottos, String winningNumber) {
        int[] numbers = Cast.castToNumber(winningNumber);

        for(int i = 0; i < lottos.size(); i++) {
            makeResult(count(lottos.get(i), numbers));
        }
        return result;
    }

    public static void makeResult(int count) {
        Rank[] ranks = values();
        for(int j = 0; j < ranks.length; j++) {
            result[j] = (ranks[j].count == count) ? (result[j] + 1): result[j];
        }
    }

    private static int count(List list, int[] numbers) {
        int count = 0;
        for(int i = 0; i < numbers.length; i++) {
            count = list.contains(numbers[i]) ? (count + 1) : count;
        }
        return count;
    }

}