package step2.controller;

import step2.domain.LottoNo;
import step2.util.Cast;

import java.util.List;

public enum Rank {
    MATCH3(3, 5000),
    MATCH4(4, 50000),
    MATCH5(5, 1500000),
    MATCH6(6, 2000000000);

    private static final int LOTTO_PRICE = 1000;
    private static int[] result = {0, 0, 0, 0};
    private final int count;
    private final int money;


    Rank(int count, int money) {
        this.count = count;
        this.money = money;
    }

    public static int[] result(List<LottoNo> lottoNos, String winningNumber) {
        int[] numbers = Cast.castToNumber(winningNumber);

        for(int i = 0; i < lottoNos.size(); i++) {
            makeResult(count(lottoNos.get(i), numbers));
        }
        return result;
    }

    public static void makeResult(int count) {
        Rank[] ranks = values();
        for(int j = 0; j < ranks.length; j++) {
            result[j] = (ranks[j].count == count) ? (result[j] + 1): result[j];
        }
    }

    private static int count(LottoNo lottoNo, int[] numbers) {
        int count = 0;
        for(int i = 0; i < numbers.length; i++) {
            count = lottoNo.contains(numbers[i]) ? (count + 1) : count;
        }
        return count;
    }

    public static float create(int count, int[] result) {
        int sum = 0;
        Rank[] revenues = values();
        for(int i = 0; i < result.length; i++) {
            sum += result[i] * revenues[i].money;
        }
        return (float)sum / (count * LOTTO_PRICE);
    }

}