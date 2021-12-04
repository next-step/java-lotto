package edu.nextstep.camp.lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static int inputNumber(String message) {
        System.out.println(message);
        int number = scanner.nextInt();
        // 계속 다음 입력에서 빈 임력이 들어와버린다. 버퍼에 뭐가 남아있나..
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }

        return number;
    }

    public static Set<Integer> inputLottoNumber() {
        String numbers = scanner.nextLine();

        return Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
    }

    public static int inputBudget() {
        return inputNumber("구입 금액을 입력해 주세요.");
    }

    public static int inputAmountOfManualPurchase() {
        return inputNumber("수동으로 구매할 로또 수를 입력해 주세요.");
    }

    public static List<Set<Integer>> inputManualLottos(int amount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<Set<Integer>> lottos = new ArrayList<>(amount);
        while (lottos.size() < amount) {
            lottos.add(inputLottoNumber());
        }

        return lottos;
    }

    public static Set<Integer> inputWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return inputLottoNumber();
    }

    public static int inputBonusNumber() {
        return inputNumber("보너스 번호를 입력해 주세요.");
    }
}
