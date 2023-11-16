package lotto.view;

import lotto.domain.lotto.wrapper.LottoNumbers;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final int LOTTO_PRICE = 1000;
    private static final String DELIMITER = ",";

    private final Scanner sc;
    private final InputValidator inputValidator;

    private String input;

    public InputView() {
        this.sc = new Scanner(System.in);
        this.inputValidator = new InputValidator();
    }

    public int inputPurchaseMoney() {
        System.out.println("구입금액을 입력해 주세요");
        input = sc.nextLine();

        validatePurchaseMoney();

        return calculateNumOfLotto(input);
    }

    private void validatePurchaseMoney() {
        try {
            inputValidator.validatePurchaseMoney(input, LOTTO_PRICE);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            input = sc.nextLine();
            validatePurchaseMoney();
        }
    }

    private int calculateNumOfLotto(String purchase) {
        return (int) Long.parseLong(purchase) / LOTTO_PRICE;
    }

    public LottoNumbers inputWinningNumbers() {
        clearInput();

        System.out.println("이번 주 당첨 번호를 입력해 주세요.");
        input = sc.nextLine();

        validateWinningNumbers();

        return convertToNumbers(input);
    }

    private void clearInput() {
        input = "";
    }

    private void validateWinningNumbers() {
        try {
            inputValidator.validateWinningNumbers(input, DELIMITER);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            input = sc.nextLine();
            validateWinningNumbers();
        }
    }

    private LottoNumbers convertToNumbers(String input) {
        String[] stringNumbers = input.split(DELIMITER);

        return new LottoNumbers(Arrays.stream(stringNumbers)
            .map(stringNumber -> Integer.parseInt(stringNumber.trim()))
            .collect(Collectors.toUnmodifiableSet()));
    }
}
