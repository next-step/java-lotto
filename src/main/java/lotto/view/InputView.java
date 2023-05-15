package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public int price() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public List<List<Integer>> manualBuy() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요");
        int count = Integer.parseInt(scanner.nextLine());

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<List<Integer>> manualList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            manualList.add(getIntegers());
        }
        return manualList;
    }

    public void buy(int quantity) {
        System.out.printf("%d개를 구매했습니다.\n", quantity);
    }

    public List<Integer> result() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return getIntegers();
    }

    private List<Integer> getIntegers() {
        String input = scanner.nextLine();
        return Arrays.stream(input.split(",\\s*"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public Integer bonus() {
        System.out.println("보너스 볼을 입력해 주세요.");
        String input = scanner.nextLine();
        return Integer.parseInt(input);
    }
}
