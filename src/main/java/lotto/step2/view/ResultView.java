package lotto.step2.view;

public class ResultView {

    public static void printLottoCount(int price) {
        if (price < 1000) {
            throw new IllegalArgumentException("금액이 부족합니다. 로또 1장의 가격은 1000원 입니다.");
        }

        System.out.printf("%d개를 구매했습니다.", price / 1000);
    }
}
