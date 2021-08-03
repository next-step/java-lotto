package lottos.controller;

import lottos.domain.Lotto;
import lottos.domain.LottoGame;
import lottos.domain.LottoRandomGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoConsoleController {

    private final Scanner scanner = new Scanner(System.in);

    public List<Lotto> buy(int amountPerPiece) {
        int purchaseAmount = enterPurchaseAmount();
        int purchaseCount = purchaseAmount / amountPerPiece;

        System.out.printf("%d개를 구매했습니다.%n", purchaseCount);

        LottoGame lottoGame = new LottoGame(new LottoRandomGenerator());
        return lottoGame.start(purchaseAmount, amountPerPiece);
    }

    public Lotto lastWeeksWinningLotto() {
        String text = enterLastWeeksNumbers();
        List<Integer> numbers = Arrays.stream(text.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        scanner.close();
        return new Lotto(numbers);
    }

    private int enterPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    private String enterLastWeeksNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }
}
