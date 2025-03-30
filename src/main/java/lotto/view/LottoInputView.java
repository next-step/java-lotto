package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoInputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String DELIMITER_REGEX = "[,\\s]+";

    public int getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int result = SCANNER.nextInt();
        SCANNER.nextLine();
        return result;
    }

    public List<List<Integer>> getLottoManualNumbers() {
        List<List<Integer>> result = new ArrayList<>();

        System.out.println();
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int lottoCount = Integer.parseInt(SCANNER.nextLine());

        System.out.println();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> manualNumbers = toNumbers(SCANNER.nextLine());
            result.add(manualNumbers);
        }
        System.out.println();

        return result;
    }

    public List<Integer> getWinningLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return toNumbers(SCANNER.nextLine());
    }

    public int getWinningLottoBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(SCANNER.nextLine());
    }

    private List<Integer> toNumbers(String text) {
        return Arrays.stream(text.split(DELIMITER_REGEX))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }


}
