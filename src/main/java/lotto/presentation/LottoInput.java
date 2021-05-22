package lotto.presentation;

import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.utils.Splitter;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LottoInput {
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_MONEY_ERROR_MESSAGE = "숫자만 입력해주세요.";
    private static final String INPUT_LOTTO_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private final Scanner scanner;

    public LottoInput() {
        scanner = new Scanner(System.in);
    }

    public Money inputMoneyToPurchaseLotto() {
        while (true) {
            try {
                System.out.println(INPUT_MONEY_MESSAGE);
                return new Money(scanner.nextInt());
            } catch (InputMismatchException e) {
                System.out.println(INPUT_MONEY_ERROR_MESSAGE);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                scanner.nextLine();
            }
        }
    }

    public Lotto inputAnswerLottoNumbers() {
        while (true) {
            try {
                System.out.println(INPUT_LOTTO_NUMBERS_MESSAGE);
                String answerLottoNumbers = scanner.next();
                return new Lotto(Splitter.split(answerLottoNumbers));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                scanner.nextLine();
            }
        }
    }
}
