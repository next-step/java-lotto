package lotto.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int readAmount() {
        System.out.println("구매금액을 입력해 주세요.");
        return readInt();
    }

    public static int readManualCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return readInt();
    }

    public static List<List<Integer>> readManualNumbers(int count) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<List<Integer>> manualNumbers = new ArrayList<>();
        while (count-- > 0) {
            String manualNumbersString = readString();
            manualNumbers.add(convertStringToIntegerList(manualNumbersString));
        }
        return manualNumbers;
    }

    public static List<Integer> readWinNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해주세요.");

        String winNumbersString = readString();
        return convertStringToIntegerList(winNumbersString);
    }

    public static int readBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return readInt();
    }

    private static List<Integer> convertStringToIntegerList(String winNumbersString) {
        List<String> winNumbersStrings = List.of(winNumbersString.split(",\\s*"));
        return winNumbersStrings.stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    private static int readInt() {
        return Integer.parseInt(SCANNER.nextLine());
    }

    private static String readString() {
        return SCANNER.nextLine();
    }


}
