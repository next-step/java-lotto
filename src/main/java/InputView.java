import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static Money askMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String moneyStr = scanner.nextLine();

        return new Money(moneyStr);
    }

    public static Lotto askWinning() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningStr = scanner.nextLine();

        return new Lotto(winningStr);
    }

    public static BonusBall askBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        String bonusNumStr = scanner.nextLine();

        return new BonusBall(bonusNumStr);
    }

    public static int askManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        String countStr = scanner.nextLine();

        return Integer.parseInt(countStr);
    }

    public static Candidates askManualLottos(int count) {
        Candidates candidates = new Candidates();

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        for(int i = 0; i < count; i++) {
            String lottoStr = scanner.nextLine();

            candidates.add(new Candidate(new Lotto(lottoStr)));
        }

        return candidates;
    }
}
