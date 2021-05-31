package step5.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class InputView {

    private static final String DEFAULT_REGEX = ", ";


    public static int purchaseAmount() {
        Scanner sc = new Scanner(System.in);

        System.out.println("구입 금액을 입력해 주세요.");
        return sc.nextInt();
    }

    public static int getManualNumber() {
        Scanner sc = new Scanner(System.in);

        System.out.println("수동 으로 구매할 로또 수를 입력해 주세요.");
        return sc.nextInt();
    }
    public static void showInputManualLotto() {
        System.out.println("수동 으로 구매할 번호를 입력해 주세요.");
    }
    public static List<Integer> getLottoManually() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] split = input.split(DEFAULT_REGEX);
        return Arrays.stream(split).map(Integer::parseInt).collect(toList());
    }


    public static List<Integer> getLotto() {
        Scanner sc = new Scanner(System.in);

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = sc.nextLine();
        String[] split = input.split(DEFAULT_REGEX);
        return Arrays.stream(split).map(Integer::parseInt).collect(toList());
    }

    public static int getBonusNumber() {
        Scanner sc = new Scanner(System.in);

        System.out.println("보너스 볼을 입력해 주세요.");
        return sc.nextInt();
    }
}
