package ui;

import domain.Lottos;

public class ResultView {
    private static final String BUYING_AMOUNT_IS = "개를 구매했습니다.";

    public static void print(Lottos lottos) {
        System.out.print(lottos.size());
        System.out.println(BUYING_AMOUNT_IS);

        lottos.stream().forEach(System.out::println);
    }
}
