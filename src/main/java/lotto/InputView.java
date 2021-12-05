package lotto;

import java.util.EnumMap;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int totalCost() {
        System.out.println("구입 금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static void quantity(int quantity) {
        System.out.println(quantity + "개를 구매했습니다.");
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

    public static void summary(EnumMap<MatchedNumbers, Long> result) {
        for (MatchedNumbers matchedNumbers : result.keySet()) {
            System.out.println(matchedNumbers.count() + "개 일치: " + result.get(matchedNumbers));
        }
    }

    public static void profit(float profit) {
        System.out.printf("수익률: %.2f", profit);
    }
}
