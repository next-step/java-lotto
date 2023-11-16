package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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


    public static List<Integer> inputLastWeekLottoNumbers() {
        printLastWeekLottoNumbers();
        return parseLottoNumbers(scanner.nextLine());
    }

    private static int parseInt(String input) {
        return Integer.parseInt(input);
    }

    private static List<Integer> parseLottoNumbers(String input) {
        input = removeTrim(input);
        List<String> lottoNumbersString = Arrays.asList(input.split(","));
        List<Integer> parsedLottoNumbers = lottoNumbersString.stream().mapToInt(Integer::parseInt).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        return parsedLottoNumbers;
    }

    private static String removeTrim(String originString) {
        originString = originString.replace(" ", "");
        return originString;
    }

}
