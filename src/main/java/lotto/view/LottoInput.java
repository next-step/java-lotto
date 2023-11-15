package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoInput {
    static Scanner scanner = new Scanner(System.in);

    public int getInput() {
        System.out.println("구입금액을 입력하세요.");
        return scanner.nextInt();
    }

    public List<Integer> getWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        scanner.nextLine();
        return Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
