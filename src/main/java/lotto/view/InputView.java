package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    public int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public List<Integer> inputLastWeeksCollectNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String lastWeeksCollectNumbers = scanner.nextLine();
        String[] split = lastWeeksCollectNumbers.split(", ");
        return Arrays
                .stream(split)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }
}