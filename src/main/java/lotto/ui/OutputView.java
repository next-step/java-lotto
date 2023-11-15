package lotto.ui;

public class OutputView {

    public static void outputQuantity(int amount) {
        System.out.println(numberOfLottos(amount) + "개를 구매했습니다.");
    }

    private static int numberOfLottos(int amount) {
        return amount / 1000;
    }
}
