package lotto.view;


import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import static java.lang.System.*;

public class InputView {

    private static final int LOTTO_PRICE = 1000;
    private static final String DELIMITER = ",";

    private final Scanner sc;
    private final InputValidator inputValidator;

    public InputView() {
        this.sc = new Scanner(in);
        this.inputValidator = new InputValidator();
    }

    public int inputCountOfManual(int numOfLotto) {
        print("수동으로 구매할 로또 수를 입력해 주세요.");

        try {
            String countOfManual = input();
            inputValidator.validateCountOfManual(countOfManual, numOfLotto);

            return Integer.parseInt(countOfManual);
        } catch (IllegalArgumentException e){
            print(e.getMessage());
            return inputCountOfManual(numOfLotto);
        }
    }

    private int calculateNumOfLotto(String purchase) {
        return (int) Long.parseLong(purchase) / LOTTO_PRICE;
    }

    public int inputPurchaseMoney() {
        print("구입 금액을 입력해주세요.");

        try {
            String purchase = input();
            inputValidator.validatePurchaseMoney(purchase, LOTTO_PRICE);

            return calculateNumOfLotto(purchase);
        } catch (IllegalArgumentException e){
            print(e.getMessage());
            return inputPurchaseMoney();
        }
    }

    public Set<Integer> inputWinningNumbers() {
        print("이번 주 당첨 번호를 입력해 주세요.");

        try {
            String input = input();
            inputValidator.validateWinningNumbers(input, DELIMITER);

            return convertToNumbers(input);
        } catch (IllegalArgumentException e){
            print(e.getMessage());
            return inputWinningNumbers();
        }
    }

    private Set<Integer> convertToNumbers(String input) {
        String[] stringNumbers = input.split(DELIMITER);

        return Arrays.stream(stringNumbers)
            .map(stringNumber -> Integer.parseInt(stringNumber.trim()))
            .collect(Collectors.toUnmodifiableSet());
    }

    public int inputBonusNumber(Set<Integer> winningNumbers) {
        print("보너스 볼을 입력해주세요.");

        try {
            String input = input();
            inputValidator.validateBonusNumber(input, winningNumbers);

            return Integer.parseInt(input);
        } catch (IllegalArgumentException e){
            print(e.getMessage());
            return inputBonusNumber(winningNumbers);
        }
    }

    private String input() {
        return sc.nextLine();
    }

    private void print(String message) {
        out.println(message);
    }
}
