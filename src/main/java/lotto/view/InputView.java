package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static int askPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanInt();
    }

    public static Lotto askLottoWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return getLotto();
    }

    private static Lotto getLotto() {
        return new Lotto(parseInt(asList(split(scanner.nextLine()))));
    }

    private static int scanInt() {
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }

    private static String[] split(String winningNumbers) {
        return winningNumbers.split(", |,");
    }

    private static List<String> asList(String[] winningNumbers) {
        return Arrays.asList(winningNumbers);
    }

    private static Set<Integer> parseInt(List<String> winningNumbers) {
        return winningNumbers.stream()
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toSet());
    }

    public static LottoNumber askBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return new LottoNumber(scanInt());
    }

    public static List<Lotto> askManualLottoCountAndNumber() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualLottoCount = scanInt();

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<Lotto> lottoList = new ArrayList<>();
        for (int index = 0; index < manualLottoCount; index++) {
            lottoList.add(getLotto());
        }

        return lottoList;
    }
}
