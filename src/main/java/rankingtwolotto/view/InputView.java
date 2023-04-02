package rankingtwolotto.view;

import rankingtwolotto.domain.Lotto;
import rankingtwolotto.domain.LottoNumber;
import rankingtwolotto.rankingexception.ExceptionCommand;
import rankingtwolotto.rankingexception.RankingValueException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final int LOTTO_MIN_PRICE = 1000;
    private static final Scanner sc = new Scanner(System.in);

    public static int enterPurchaseAmount() {
        System.out.println("구입금액을 입력해주세요.");
        int purchaseAmount = sc.nextInt();
        validatePurchaseAmount(purchaseAmount);
        return purchaseAmount;
    }

    private static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < LOTTO_MIN_PRICE) {
            throw new RankingValueException(ExceptionCommand.PRICE_EXCEPTION_MESSAGE);
        }
    }

    public static Lotto winningNumber() {
        String lastWinningNumber = enterWinningNumbers();
        lastWinningNumber = lastWinningNumber.trim();
        int[] lastWinningNumbers = Arrays.stream(lastWinningNumber.split(","))
                .mapToInt(Integer::parseInt).sorted().toArray();
        List<LottoNumber> winningNumbers = new ArrayList<>();
        for (int winningNumber : lastWinningNumbers) {
            winningNumbers.add(new LottoNumber(winningNumber));
        }

        return new Lotto(winningNumbers);
    }

    private static String enterWinningNumbers() {
        sc.nextLine();
        System.out.println("지난주 당첨번호를 입력해주세요.");
        String lastWinningNumber = sc.nextLine();
        return lastWinningNumber;
    }

    public static LottoNumber enterBonusBallNumber() {
        System.out.println("보너스 볼을 입력해주세요.");
        int bonusBallNumber = sc.nextInt();
        LottoNumber bonusBall = new LottoNumber(bonusBallNumber);
        return bonusBall;
    }

}
