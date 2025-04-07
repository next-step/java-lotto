package Lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public int getPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public List<Integer> getWinnerNumbers(){
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String line = scanner.nextLine();
        List<Integer> numbers = Arrays.stream(line.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return numbers;
    }

    public int getBonusNumber(){
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public int getManualPurchaseNumber(){
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }
}
