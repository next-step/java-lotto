package lotto;

import java.util.HashMap;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int EACH_PRICE = 1000;

    public static int quantity() {
        System.out.println("구입 금액을 입력해 주세요.");
        int price = scanner.nextInt();

        int quantity = price / EACH_PRICE;
        System.out.println(quantity + "개를 구매했습니다.");

        return quantity;
    }

    public static void print(Lottos lottos) {
        for (Lotto lotto : lottos.values()) {
            System.out.println(lotto.lottoNumbers());
        }
    }

    public static LottoNumbers winningNumbers() {
        System.out.println("당첨 번호를 입력해주세요");
        return new LottoNumbers(scanner.next());
    }

    public static void summary(HashMap<Integer, Long> result) {
        for (Integer integer : result.keySet()) {
            System.out.println(integer + "개 일치: " + result.get(integer));
        }
    }
}
