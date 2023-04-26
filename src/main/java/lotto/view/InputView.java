package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Deprecated
public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    public static final String SPLIT_REGEX = ",";

    @Deprecated
    public static long purchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        long purchaseAmount = scanner.nextLong();

        if (purchaseAmount < 1000) {
            System.out.println("구입금액은 1,000원보다 작을 수 없습니다. 입력금액: " + purchaseAmount);
            throw new IllegalArgumentException("구입금액은 1,000원보다 작을 수 없습니다.");
        }

        return purchaseAmount;
    }

    @Deprecated
    public static int manualQuantity(long purchaseAmount) {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualQuantity = scanner.nextInt();

        if (manualQuantity > purchaseAmount / Lottos.LOTTO_PRICE) {
            throw new IllegalArgumentException(
                    "구매 금액을 초과하였습니다. 최대 " + purchaseAmount / Lottos.LOTTO_PRICE + "수량만큼 구매가능합니다.");
        }

        return manualQuantity;
    }

    @Deprecated
    public static List<Lotto> manualNumbers(int manualQuantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < manualQuantity; i++) {
            System.out.println("수동으로 구매할 번호를 입력해 주세요.");
            scanner.nextLine();

            String strNumbers = scanner.nextLine();
            lottos.add(new Lotto(convertNumbers(strNumbers)));
        }

        return lottos;
    }

    @Deprecated
    public static List<Integer> lastWeekWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        String strNumbers = scanner.nextLine();
        return convertNumbers(strNumbers);
    }

    @Deprecated
    public static int bonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }

    private static List<Integer> convertNumbers(String strNumbers) {
        return Arrays.stream(strNumbers.split(SPLIT_REGEX)).map(s -> {
            s = s.trim();
            return Integer.parseInt(s);
        }).collect(Collectors.toList());
    }
}
