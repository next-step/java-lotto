package step4.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoInputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static List<Integer> getLastDrawNumbersWithPrompt(String message) {
        System.out.println(message);

        return parseLottoNumbersString(SCANNER.nextLine());
    }

    private static List<Integer> parseLottoNumbersString(String lastDrawResultString) {
        return Arrays.stream(lastDrawResultString.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static List<List<Integer>> getManualLottoNumbersWithPrompt(int numberOf, String message) {
        System.out.println(message);
        SCANNER.nextLine();     // 엔터값 제거

        return Stream.generate(SCANNER::nextLine)
                .limit(numberOf)
                .map(LottoInputView::parseLottoNumbersString)
                .collect(Collectors.toList());
    }

    public static int getIntegerWithMessage(String message) {
        System.out.println(message);

        return SCANNER.nextInt();
    }
}
