package lotto.view;

import lotto.domain.Lotto;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String REQUEST_MONEY_INPUT_MESSAGE = "구입금을 입력해 주세요.";
    private static final String WRONG_INPUT_MESSAGE = "잘못된 입력입니다. 다시 입력해주세요.";
    private static final String LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.";
    private static final String REQUEST_WIN_LOTTO_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String DELIMITER = "\\s*,\\s*";

    private Scanner input = new Scanner(System.in);
    private PrintStream output = new PrintStream(System.out);

    public int takeMoney() {
        output.println(REQUEST_MONEY_INPUT_MESSAGE);
        int money = 0;
        while(money <= 0) {
            money = parseMoney();
        }
        output.println(String.format(LOTTO_COUNT_MESSAGE, money / Lotto.PRICE));
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
        output.println(REQUEST_WIN_LOTTO_NUMBER_MESSAGE);
        while (lottoNumbers.size() != Lotto.NUMBER_COUNT) {
            lottoNumbers = new ArrayList(parseLottoNumbers());
        }
        enter();
        return lottoNumbers;
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

    public void enter() {
        output.println("");
    }


}
