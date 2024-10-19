package lotto.view;

import java.util.List;

public class ResultView {

    private ResultView() {

    }

    public static void printLottoAmount(int amount) {
        System.out.println("총" + amount + "개를 구매했습니다.");
    }

    public static void printLottoNumbers(List<Integer> selectedNumbers) {
        System.out.println(selectedNumbers);
    }
}
