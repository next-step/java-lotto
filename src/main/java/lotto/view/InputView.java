package lotto.view;

import lotto.domain.*;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {
    public static int inputBuyPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();
    }

    public static int issueLottos() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static int[] inputLastWeekWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String inputWinningNumbers = scanner.nextLine();
        String[] splitWinningNumbers = inputWinningNumbers.replaceAll(" ", "").split(",");
        return Arrays.stream(splitWinningNumbers).mapToInt(Integer::parseInt).toArray();
    }

    public static int inputLastWeekBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

    public static void issueLottos(LottoGame lottoGame, int manualQuantity) {
        if (manualQuantity == 0) {
            return;
        }

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < manualQuantity; i++) {
            String inputNumbers = scanner.nextLine();
            int[] numbers = Arrays.stream(inputNumbers.replaceAll(" ", "").split(","))
                    .map(Integer::valueOf)
                    .mapToInt(a -> a).toArray();

            lottoGame.issueLotto(new ManualLottoGenerator(new Lotto(LottoType.MANUAL, numbers)));
        }

        issueRandomLottos(lottoGame);
    }

    private static void issueRandomLottos(LottoGame lottoGame) {
        long availableQuantity = lottoGame.getAvailableQuantity();
        for (long i = 0; i < availableQuantity; i++) {
            lottoGame.issueLotto(new RandomLottoGenerator());
        }
    }
}
