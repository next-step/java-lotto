package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String readLottoMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextLine();
    }

    public static String readCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static List<List<Integer>> readLottos(final int count) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<List<Integer>> lottos = new ArrayList<>();
        for (int number = 0; number < count; number++) {
            lottos.add(readLotto());
        }
        return lottos;
    }


    public static List<Integer> readLotto() {
        return Arrays.stream(scanner.nextLine()
                .split(","))
            .map(String::trim)
            .map(Integer::valueOf)
            .collect(toList());
    }

    public static List<Integer> readWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return readLotto();
    }

    public static int readBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

}
