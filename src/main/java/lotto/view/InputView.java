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

    public InputView() {
        this.sc = new Scanner(System.in);
        this.inputValidator = new InputValidator();
    }

    public int inputPurchaseMoney() {
        System.out.println("구입금액을 입력해 주세요");
        String input = validatePurchaseMoney();

        return calculateNumOfLotto(input);
    }

    private String validatePurchaseMoney() {
        String input;

        while (true) {
            input = sc.nextLine();
            try {
                inputValidator.validatePurchaseMoney(input, LOTTO_PRICE);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }

        return input;
    }

    private int calculateNumOfLotto(String purchase) {
        return (int) Long.parseLong(purchase) / LOTTO_PRICE;
    }

    public LottoNumbers inputWinningNumbers() {
        System.out.println("이번 주 당첨 번호를 입력해 주세요.");
        String input = validateWinningNumbers();

        return convertToNumbers(input);
    }

    private String validateWinningNumbers() {
        String input;

        while (true) {
            input = sc.nextLine();
            try {
                inputValidator.validateWinningNumbers(input, DELIMITER);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }

        return input;
    }

    private LottoNumbers convertToNumbers(String input) {
        String[] stringNumbers = input.split(DELIMITER);

        return new LottoNumbers(Arrays.stream(stringNumbers)
            .map(stringNumber -> Integer.parseInt(stringNumber.trim()))
            .collect(Collectors.toUnmodifiableList()));
    }
}
