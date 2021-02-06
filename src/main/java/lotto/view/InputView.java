package lotto.view;

import lotto.utils.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static String input;

    public static int inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        input = scanner.nextLine();
        return parseInt(input);
    }

    public static int inputManualPurchaseCount(){
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        input = scanner.nextLine();
        return parseInt(input);
    }

    public static List<List<Integer>> inputManualPurchaseLottoNumber(int manualCount){
        List<List<Integer>> manualLottoNumbers = new ArrayList<>();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for(int i = 0; i < manualCount; ++i){
            input = scanner.nextLine();
            List<Integer> manualLottoNumber = Arrays.stream(input.split(","))
                    .map(InputView::parseInt)
                    .collect(Collectors.toList());
            manualLottoNumbers.add(manualLottoNumber);
        }
        return manualLottoNumbers;
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        input = scanner.nextLine();
        return Arrays.stream(input.split(","))
                .map(InputView::parseInt)
                .collect(Collectors.toList());
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        input = scanner.nextLine();
        return parseInt(input);
    }

     private static int parseInt(String input){
         Validator.checkNumberValidation(input);
        return Integer.parseInt(input);
     }
}
