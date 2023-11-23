package lotto.view;

import java.util.Arrays;
import java.util.Scanner;

import static lotto.view.ResultView.printInputMoney;
import static lotto.view.ResultView.printLastWeekLottoNumbers;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static int inputMoney() {
        printInputMoney();
        return parseInt(scanner.nextLine());
    }


    public static int [] inputLastWeekLottoNumbers() {
        printLastWeekLottoNumbers();
        String input = scanner.nextLine();
        return parseLottoNumbers(input);
    }

    private static int parseInt(String input) {
        return Integer.parseInt(input);
    }

    private static int [] parseLottoNumbers(String input) {
        input = removeTrim(input);
        String [] lottoNumbersString = input.split(",");

        return Arrays.stream(lottoNumbersString)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static String removeTrim(String originString) {
        originString = originString.replace(" ", "");
        return originString;
    }

}
