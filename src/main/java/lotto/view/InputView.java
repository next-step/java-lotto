package lotto.view;

import lotto.exception.InvalidLottoException;
import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.LottoNumberFactory;
import lotto.model.Money;
import lotto.model.WinningLotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static lotto.validation.MoneyValidator.assertMoney;
import static lotto.validation.WinningInfoValidator.assertDuplicatedBonus;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public Money askMoney() {
        System.out.println("구입금액을 입력해 주세요.");

        try {
            int amount = toInt(SCANNER.nextLine());

            assertMoney(amount);

            return new Money(amount);
        } catch (IllegalArgumentException | InvalidLottoException e) {
            System.out.println(e.getMessage());
        }

        return askMoney();
    }

    public List<String> askManualLotto(Money money) {
        int quantity = askManualQuantity(money);
        return askManualLotto(quantity);
    }

    public int askManualQuantity(Money money) {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");

        try {
            int quantity = toInt(SCANNER.nextLine());

            money.assertPurchasable(quantity);

            return quantity;
        } catch (IllegalArgumentException | InvalidLottoException e) {
            System.out.println(e.getMessage());
        }

        return askManualQuantity(money);
    }

    public List<String> askManualLotto(int quantity) {
        if (quantity <= 0) {
            return Collections.emptyList();
        }

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        try {
            List<String> result = new ArrayList<>();

            for (int i = 1; i <= quantity; i++) {
                result.add(SCANNER.nextLine());
            }

            return result;
        } catch (InvalidLottoException e) {
            System.out.println(e.getMessage());
        }

        return askManualLotto(quantity);
    }

    public WinningLotto askWinningLotto() {
        Lotto winningNumberLotto = askWinningNumbers();
        LottoNumber bonusNumber = askBonusNumber(winningNumberLotto);
        return new WinningLotto(winningNumberLotto, bonusNumber);
    }

    private Lotto askWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        try {
            return toLotto();
        } catch (InvalidLottoException e) {
            System.out.println(e.getMessage());
        }

        return askWinningNumbers();
    }

    private Lotto toLotto() {
        return LottoNumberFactory.of(convertTo(SCANNER.nextLine()));
    }

    private Integer[] convertTo(String input) {
        return Arrays.stream(input.split(","))
                .mapToInt(this::toInt)
                .boxed()
                .toArray(Integer[]::new);
    }

    private LottoNumber askBonusNumber(Lotto winningLottoNumber) {
        System.out.println("보너스 볼을 입력해 주세요.");

        try {
            int bonus = toInt(SCANNER.nextLine());
            LottoNumber bonusNumber = new LottoNumber(bonus);

            assertDuplicatedBonus(winningLottoNumber, bonusNumber);

            return bonusNumber;
        } catch (InvalidLottoException ex) {
            System.out.println(ex.getMessage());
        }

        return askBonusNumber(winningLottoNumber);
    }

    private int toInt(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new InvalidLottoException("정수를 입력해 주세요", e);
        }
    }
}
