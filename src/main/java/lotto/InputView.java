package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public static int askAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = new Scanner(System.in).nextInt();
        if (amount < Lottos.LOTTO_AMOUNT) {
            throw new IllegalArgumentException("로또 금액보다 적은 금액이 입력됐습니다. : " + amount + " < " + Lottos.LOTTO_AMOUNT);
        }
        return amount;
    }

    public static List<Number> askWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String line = new Scanner(System.in).nextLine();
        String[] numbers = line.split(",");
        List<Number> winningNumbers = new ArrayList<>();
        for (String number : numbers) {
            winningNumbers.add(new Number(Integer.parseInt(number.trim())));
        }
        return winningNumbers;
    }

    public static void printPurchaseComplete(Lottos lottos) {
        System.out.println(lottos.lottos().size() + "개를 구매했습니다.");
        String result = "";
        for (Lotto lotto : lottos.lottos()) {
            result += lotto.numbers();
            result += "\n";
        }
        System.out.println(result);
    }

}
