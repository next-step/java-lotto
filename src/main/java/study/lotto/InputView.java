package study.lotto;

import java.math.BigDecimal;
import java.util.Scanner;

public class InputView {
    private BigDecimal purchaseAmount;
    private int purchaseCount;
    private LottoGame lottoGame;

    public InputView(LottoGame lottoGame) {
        this.lottoGame = lottoGame;
    }

    public void purchase() {
        purchaseAmount = inputPurchaseAmount();
        lottoGame.purchase(purchaseAmount);
        purchaseCount = lottoGame.purchaseableLotto(purchaseAmount);
        System.out.println(purchaseCount+"개를 구매했습니다.");
        print(lottoGame.purchasedLotto());
    }

    private BigDecimal inputPurchaseAmount() {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        boolean isRightPrice = false;
        while (!isRightPrice){
            System.out.println("구입금액을 입력해주세요.");
            input = scanner.next();
            isRightPrice = checkInput(input);
        }
        return BigDecimal.valueOf(Long.parseLong(input));
    }

    private boolean checkInput(String input) {
        return input.chars().allMatch(Character::isDigit) && Long.parseLong(input) >= 1000;
    }

    private void print(PurchasedLottos purchasedLottos) {
        for (LottoPaper purchasedLotto : purchasedLottos.values()) {
            System.out.println(purchasedLotto.markedLottoNumbers().value());
        }
    }

    public void draw() throws IllegalAccessException {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String inputWinningNumbers = scanner.nextLine();
        lottoGame.draw(new WinningNumbers(inputWinningNumbers));
    }

}
