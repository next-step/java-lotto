package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class LottoGameApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("구매금액을 입력해 주세요.");
        int price = scanner.nextInt();

        LottoGame lottoGame = new LottoGame();
        int purchaseCount = lottoGame.purchaseLotto(price);

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String value = scanner.nextLine();

        List<Integer> winningNumbers = Arrays.stream(value.split(","))
                .map(Integer::new)
                .collect(toList());

        Lotto winningLotto = new Lotto(winningNumbers);
    }
}
