package view;

import domain.LottoGame;
import domain.WinningInfos;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {
    public static final Scanner scanner = new Scanner(System.in);

    public static int getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static LottoGame getLottoGame(int money) {
        List<String> manualLottoRaw = getManualLottoRaw();

        return LottoGame.of(money, manualLottoRaw);
    }

    private static List<String> getManualLottoRaw() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int count = Integer.parseInt(scanner.nextLine());

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        return getManualLottoRaw(count);
    }

    private static List<String> getManualLottoRaw(int count) {
        return IntStream.range(0, count)
                .boxed()
                .map(e -> scanner.nextLine())
                .collect(Collectors.toList());
    }

    public static WinningInfos getWinningInfos(LottoGame lottoGame) {
        String winningNumberStr = InputView.getWinningNumberString();
        String bonusLottoNumber = InputView.getBonusNumber();
        return lottoGame.getWinningInfos(winningNumberStr, bonusLottoNumber);
    }

    private static String getWinningNumberString() {
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        return scanner.nextLine();
    }

    private static String getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextLine();
    }
}