package lotto.view;

import lotto.exception.InvalidLottoException;
import lotto.model.Lotto;
import lotto.model.LottoNumberFactory;

import java.util.Arrays;
import java.util.Scanner;

import static lotto.validation.LottoMachineValidator.assertMoney;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public int askMoney() {
        System.out.println("구입금액을 입력해 주세요.");

        try {
            int money = toInt(SCANNER.nextLine());

            assertMoney(money);

            return money;
        } catch (InvalidLottoException e) {
            System.out.println(e.getMessage());
        }

        return askMoney();
    }

    public Lotto askWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        try {
            Integer[] winningNumbers = convertTo(SCANNER.nextLine());
            return LottoNumberFactory.of(winningNumbers);
        } catch (InvalidLottoException e) {
            System.out.println(e.getMessage());
        }

        return askWinningNumbers();
    }

    private Integer[] convertTo(String input) {
        return Arrays.stream(input.split(","))
                .mapToInt(this::toInt)
                .boxed()
                .toArray(Integer[]::new);
    }

    private int toInt(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new InvalidLottoException("정수를 입력해 주세요", e);
        }
    }

}
