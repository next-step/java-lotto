package step4.view;

import step4.domain.Lotto;

import java.util.Arrays;
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

    public static String inputLastWeekNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return SCANNER.next();
    }

    public static String inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return SCANNER.next();
    }

    public static int inputManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public static List<Lotto> askManualLottoNumbers(int numberOfManualLottos) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        SCANNER.skip("[\\r\\n]+");

        return IntStream.range(0, numberOfManualLottos)
                .mapToObj(i -> setManualLottoNumbers())
                .collect(Collectors.toList());
    }

    private static Lotto setManualLottoNumbers() {
        Lotto lotto = new Lotto();
        lotto.getLottos().clear();

        Arrays.stream(SCANNER.nextLine().split(","))
                .forEach(lottoNumber -> lotto.getLottos().add(Integer.parseInt(lottoNumber)));
        return lotto;
    }

    public static void close() {
        SCANNER.close();
    }
}
