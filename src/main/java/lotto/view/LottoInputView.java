package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoInputView {

    private static Scanner scanner;
    private static final Integer LOTTO_PRICE = 1000;

    public static void initiateScanner() {
        scanner = new Scanner(System.in);
    }

    public static Integer scanAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        Integer amount = scanner.nextInt();
        scanner.nextLine();

        return amount;
    }

    public static String scanWinNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static Lotto createLottoWithScan(String numberString) {
        String[] numbers = numberString.split(", ");

        return LottoFactory.createLotto(
                Arrays.stream(numbers)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList()));
    }

    public static List<Lotto> createPurchasedLottos(Integer amount) {
        List<Lotto> purchasedLottos = new ArrayList<>();
        int count = amount / LOTTO_PRICE;

        for (int i = 0; i < count; i++) {
            purchasedLottos.add(
                    LottoFactory.createLottoWithRandomNumbers());
        }

        return purchasedLottos;
    }
}
