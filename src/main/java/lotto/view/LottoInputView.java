package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoInputView {
    public static final Scanner SCANNER = new Scanner(System.in);

    public int inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int number = scanNumber();
        System.out.println();
        return number;
    }

    public List<List<Integer>> inputLottoTicketNumbers() {
        List<List<Integer>> input = IntStream.range(0, inputLottoCount())
                .mapToObj(i -> inputLottoNumbers())
                .collect(Collectors.toList());

        System.out.println();
        return input;
    }

    private int inputLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int number = scanNumber();
        System.out.println();
        return number;
    }

    private List<Integer> inputLottoNumbers() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        return scanNumbersWithComma();
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanNumbersWithComma();
    }

    public int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        int number = scanNumber();
        System.out.println();
        return number;
    }

    private int scanNumber() {
        int number = SCANNER.nextInt();
        SCANNER.nextLine();
        return number;
    }

    private static List<Integer> scanNumbersWithComma() {
        String[] numberTexts = SCANNER.nextLine().split(", ");

        List<Integer> result = new ArrayList<>();
        for (String numberText : numberTexts) {
            result.add(Integer.parseInt(numberText));
        }
        return result;
    }
}
