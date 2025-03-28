package view;

import java.util.List;

public class OutputView {

    public static void showResult(int result) {
        System.out.println("result = " + result);
    }

    public static void showLottoQuantity(int lottoQuantity) {
        System.out.println(lottoQuantity + "개를 구매했습니다.");
    }

    public static void showLottoNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }

}
