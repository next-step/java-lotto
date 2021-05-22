package study.lotto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private BigDecimal purchaseAmount;
    private int purchaseCount;
    private LottoGame lottoGame;

    public InputView(LottoGame lottoGame) {
        this.lottoGame = lottoGame;
    }

    public void purchase() {
        System.out.println("구입금액을 입력해주세요.");
        Scanner scanner = new Scanner(System.in);
        purchaseAmount = BigDecimal.valueOf(scanner.nextInt());
        lottoGame.purchase(purchaseAmount);
        purchaseCount = lottoGame.purchaseableLotto(purchaseAmount);
        System.out.println(purchaseCount+"개를 구매했습니다.");
        print(lottoGame.purchasedLotto());
    }

    private void print(PurchasedLottos purchasedLottos) {
        for (LottoPaper purchasedLotto : purchasedLottos.values()) {
            System.out.println(purchasedLotto.markedLottoNumbers().value());
        }
    }

    public void draw() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String inputWinningNumbers = scanner.nextLine();
        inputWinningNumbers = inputWinningNumbers.replaceAll(" ","");
        List<Integer> winningNumbers = new ArrayList<>();
        for (String stringNumber : inputWinningNumbers.split(",")) {
            winningNumbers.add(Integer.parseInt(stringNumber));
        }
        lottoGame.draw(new WinningNumbers(winningNumbers));
    }
}
