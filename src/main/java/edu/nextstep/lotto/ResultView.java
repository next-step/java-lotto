package edu.nextstep.lotto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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
        System.out.print("]");
    }

}
