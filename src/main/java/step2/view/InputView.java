package step2.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {}

    public static int purchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public static List<Integer> winningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        String winningNumber = SCANNER.next();
        String[] splitedNumber = winningNumber.split(",");

        return toList(splitedNumber);
    }

    public static int bonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public static int manualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public static List<String> manualLottoNumber(int manualLottoCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        List<String> lottoNumber = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            String purchaseNumber = SCANNER.next();
            lottoNumber.add(purchaseNumber);
        }
        return lottoNumber;
    }

    private static List<Integer> toList(String[] splitedNumber) {
        return Arrays.stream(splitedNumber)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
