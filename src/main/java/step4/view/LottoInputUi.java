package step4.view;

import step4.domain.Numbers;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoInputUi {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public static Numbers inputLastWeekNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return Numbers.of(SCANNER.next());
    }

    public static Numbers inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Numbers.of(SCANNER.next());
    }

    public static int inputManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public static List<Numbers> askManualLottoNumbers(int numberOfManualLottos) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        SCANNER.skip("[\\r\\n]+");

        return IntStream.range(0, numberOfManualLottos)
                .mapToObj(i -> SCANNER.nextLine())
                .map(Numbers::of)
                .collect(Collectors.toList());
    }

    public static void close() {
        SCANNER.close();
    }
}
