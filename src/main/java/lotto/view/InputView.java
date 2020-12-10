package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
        Scanner scanner = new Scanner(System.in);

    public int inputPayment() {
        System.out.println("구입 금액을 입력해주세요 :)");
        return Integer.parseInt(scanner.nextLine());
    }

    public int inputManualLottoCount() {
        System.out.println("\n수동으로 구매할 로또 수를 입력해주세요 :)");
        return Integer.parseInt(scanner.nextLine());
    }

    public List<List<Integer>> inputManualLottoNumbers(int manualLottoTicketCount) {
        System.out.println("\n수동으로 구매할 번호를 입력해주세요 :)");
        List<List<Integer>> manualLottoNumbers = new ArrayList<>();
        for (int i = 0; i < manualLottoTicketCount ; i++) {
            List<Integer> split = split(scanner.nextLine());
            manualLottoNumbers.add(split);
        }
        return manualLottoNumbers;
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println("\n지난 주 당첨 번호를 입력해주세요 :)");
        return split(scanner.nextLine());
    }

    public int inputBonusNumber() {
        System.out.println("\n보너스 볼을 입력해주세요 :)");
        return scanner.nextInt();
    }

    private List<Integer> split(String input) {
        List<String> strings = Arrays.asList(input.replaceAll(" ", "").split(","));
        return strings.stream().map(Integer::parseInt).collect(Collectors.toList());
    }
}
