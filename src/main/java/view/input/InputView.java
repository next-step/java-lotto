package view.input;

import model.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    private InputView() {

    }

    public static int inputBuyAmount() {
        System.out.println("구입금액을 입력해 주세요.");

        return Integer.parseInt(scanner.nextLine());
    }

    public static int inputPassiveCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");

        return Integer.parseInt(scanner.nextLine());
    }

    public static List<Lotto> inputPassiveLotto(int count) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        List<Lotto> result = new ArrayList<>();

        while (count-- > 0) {
            String[] nums = scanner.nextLine().split(",");
            Lotto lotto = new Lotto(Stream.of(nums)
                    .map(number -> Integer.parseInt(number.trim()))
                    .collect(Collectors.toList()));

            result.add(lotto);
        }

        return result;

    }

    public static List<Integer> inputWinnerLottoNum() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        String[] nums = scanner.nextLine().split(",");
        return Stream.of(nums)
                .map(number -> Integer.parseInt(number.trim()))
                .collect(Collectors.toList());
    }

    public static int inputBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");

        return Integer.parseInt(scanner.next());
    }

}
