package lotto.view;

import lotto.domain.Lotto;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String REQUEST_MONEY_INPUT_MESSAGE = "구입금을 입력해 주세요.";
    private static final String WRONG_INPUT_MESSAGE = "잘못된 입력입니다. 다시 입력해주세요.";
    private static final String REQUEST_WIN_LOTTO_NUMBER_INPUT_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String DELIMITER = "\\s*,\\s*";
    private static final String MANUAL_LOTTO_COUNT_INPUT_MESSAGE= "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_LOTTO_NUMBERS_INPUT_MESSAGE= "수동으로 구매할 번호를 입력해 주세요.";

    private Scanner input = new Scanner(System.in);
    private PrintStream output = new PrintStream(System.out);

    public int takeMoney() {
        output.println(REQUEST_MONEY_INPUT_MESSAGE);
        int money = 0;
        while(money <= 0) {
            money = parseMoney();
        }
        return money;
    }

    private Integer parseMoney() {
        try {
            return Integer.parseInt(nextLine());
        } catch(Exception e) {
            showErrorMessage();
            return 0;
        }
    }

    private void showErrorMessage() {
        output.println(WRONG_INPUT_MESSAGE);
    }

    public List<Integer> takeLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>();
        output.println(REQUEST_WIN_LOTTO_NUMBER_INPUT_MESSAGE);
        while (lottoNumbers.size() != Lotto.NUMBER_COUNT) {
            lottoNumbers = new ArrayList(parseLottoNumbers());
        }
        return lottoNumbers;
    }

    public Integer takeBonusNumber() {
        output.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(input.nextLine());
    }

    private List<Integer> parseLottoNumbers() {
        try {
            return nextIntArray();
        } catch (Exception e) {
            showErrorMessage();
        }
        return null;
    }


    private String nextLine() {
        return input.nextLine();
    }

    private List<Integer> nextIntArray() {
        String userInput = input.nextLine();

        String[] stringNumbers = userInput.split(DELIMITER);
        List<Integer> numbers = new ArrayList<>();
        for (String number : stringNumbers) {
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }

    public int takeManualLottoCount() {
        output.println(MANUAL_LOTTO_COUNT_INPUT_MESSAGE);
        return nextInt();
    }

    private int nextInt() {
        Integer nextInt = null;
        while(nextInt == null) {
            nextInt = parseCount(input.nextLine());
        }
        return nextInt;
    }

    private Integer parseCount(String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch(NumberFormatException e) {
            showErrorMessage();
        }
        return null;
    }

    public List<List<Integer>> takeManualLottoNumbers(int count) {
        output.println(MANUAL_LOTTO_NUMBERS_INPUT_MESSAGE);
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        for( int i = 0; i < count; i++) {
            lottoNumbers.add(parseLottoNumbers());
        }
        return lottoNumbers;
    }

}
