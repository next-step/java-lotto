package lotto.contoller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    public static final int LOTTO_PRICE = 1000;
    private int purchaseAmount;
    private final Scanner scanner = new Scanner(System.in);

    public int purchaseAmountQuestion() {
        System.out.println("구입금액을 입력해 주세요.");
        purchaseAmount = scanner.nextInt();
        scanner.nextLine();

        return purchaseAmount;
    }

    public List<Integer> findWinningLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return toList();
    }

    public int getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonus = scanner.nextInt();
        scanner.nextLine();

        return bonus;
    }

    public int manualLottoPurchaseCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public List<List<Integer>> getManualNumbers(int lottoCount) {
        List<List<Integer>> manualNumbers = new ArrayList<>();

        if (lottoCount > 0) {
            System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        }

        for (int i = 0; i < lottoCount; i++) {
            manualNumbers.add(toList());
        }
        System.out.println(String.format("수동으로 %d장, 자동으로 %d개를 구매했습니다.", lottoCount, (purchaseAmount / LOTTO_PRICE) - lottoCount));
        return manualNumbers;
    }

    private List<Integer> toList() {
        String value = scanner.nextLine();
        return Arrays.stream(value.split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
