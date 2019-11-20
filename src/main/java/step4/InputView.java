package step4;


import java.util.*;

public class InputView {
    private static Scanner scan = new Scanner(System.in);
    private static Set<Lotto> collectManualLotto = new LinkedHashSet<>();
    private static Set<Lotto> mergeLottos = new LinkedHashSet<>();

    public static int inputCash() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scan.nextLine());
    }

    public static int inputManual() {
        System.out.println();
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(scan.nextLine());
    }

    public static Set<Lotto> inputManualLottoNumbers(int manualCount) {
        System.out.println();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int i = 0; i < manualCount; i++) {
            String[] inputWinningNumbers = scan.nextLine().split(",");
            collectManualLotto.add(LottoGenerator.makeManualLottos(inputWinningNumbers));
            mergeLottos = Lotto.mergeLottoSets(collectManualLotto, mergeLottos);
        }
        return mergeLottos;
    }

    public static String[] inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String[] inputWinningNumbers = scan.nextLine().split(",");

        for (int i = 0; i < LottoGenerator.WINNING_NUMBERS_LENGTH; i++) {
            inputWinningNumbers[i] = inputWinningNumbers[i].trim();
        }
        return inputWinningNumbers;
    }

    public static void bonusNumberAdd(Lotto inputWinningLottoNumberList) {
        System.out.println("보너스 볼을 입력해주세요.");
        LottoLottery.lottoBonusNumber = scan.nextInt();
        LottoNumber.checkBonusNumber(inputWinningLottoNumberList);
    }
}
