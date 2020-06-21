package edu.nextstep.lotto;

import java.util.*;

public class ResultView {
    public static int lottoCount(int money) {
        System.out.println(money / 1000 + "개를 구매했습니다.");
        return money / 1000;
    }

    public static void print(String contents) {
        System.out.println(contents);
    }

    public static void printLotto(List lotto) {
        Collections.sort(lotto);

        System.out.print("[" + lotto.get(0));
        for (int i = 1; i < lotto.size(); i++) {
            System.out.print(", " + lotto.get(i));
        }
        System.out.println("]");
    }

    public static void rankView(Map<Integer, Integer> result, Map<Integer, Integer> info) {
        if (result == null) {
            throw new NullPointerException("result is null");
        }

        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            System.out.println(entry.getKey() + "개 일치 (" + info.get(entry.getKey()) + "원)- " + entry.getValue() + "개");
        }
    }

    public static void profitView(float profit) {
        String profitStrType = String.format("%.2f", profit);
        System.out.println("총 수익률은 " + profitStrType + "입니다.");
    }

}
