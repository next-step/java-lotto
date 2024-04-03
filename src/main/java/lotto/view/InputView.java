package lotto.view;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int scanAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        int amount = scanner.nextInt();
        scanner.nextLine();
        return amount;
    }

    public static int scanManualCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int count = scanner.nextInt();
        scanner.nextLine();
        return count;
    }

    public static List<Lotto> scanManualNumbers(int count) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String text = scanner.nextLine();
            List<Integer> numbers = convertStringToIntList(text);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }


    public static List<Integer> scanWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String text = scanner.nextLine();
        List<Integer> numbers = convertStringToIntList(text);
        if (numbers.size() > 6) {
            throw new IllegalArgumentException("6자리 초과의 우승 로또 번호가 입력되었습니다.");
        }
        return numbers;
    }


    public static int scanBonusNumber() {
        System.out.println("보너스 볼을 입력해주세요.");
        int bonusNumber = scanner.nextInt();
        scanner.nextLine();
        return bonusNumber;
    }

    private static List<Integer> convertStringToIntList(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
