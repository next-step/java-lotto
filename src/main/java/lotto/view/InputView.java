package lotto.view;

import lotto.model.Lottos;
import lotto.model.Order;
import lotto.model.PickNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static Order inputOrder() {
        Integer amount = askAmount();
        int handPickCount = askhandPickCount();
        return new Order(amount, handPickCount);
    }


    public static List<Integer> inputWinningNumber() {
        System.out.println("당첨번호를 입력하세요.");
        scanner = new Scanner(System.in);
        return splitNumbers(scanner.nextLine());
    }

    public static int winningBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static Integer askAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static Lottos askHandPickLottoNumber(int handPickCount) {
        Lottos lottos = new Lottos();
        for (int i = 0; i < handPickCount; i++) {
            System.out.println("수동으로 구매할 번호를 입력해 주세요.");
            scanner = new Scanner(System.in);
            lottos.add(new PickNumbers(splitNumbers(scanner.nextLine())));
        }
        return lottos;
    }

    private static int askhandPickCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    private static List<Integer> splitNumbers(String stringNumbers) {
        return Arrays.stream(stringNumbers.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }
}
