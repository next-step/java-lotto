package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static String input;

    public static String inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        input = scanner.nextLine();
        return input;
    }

    public static int inputManualPurchaseCount(){
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        input = scanner.nextLine();
        return Integer.parseInt(input);
    }

    public static List<String[]> inputManualPurchaseLottoNumber(int manualCount){
        List<String[]> manualLottoNumbers = new ArrayList<>();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for(int i = 0; i < manualCount; ++i){
            input = scanner.nextLine();
            String[] manualLottoNumber = input.split(",");
            manualLottoNumbers.add(manualLottoNumber);
        }
        return manualLottoNumbers;
    }

    public static List<String> inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        input = scanner.nextLine();
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static String inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        input = scanner.nextLine();
        return input;
    }
}
