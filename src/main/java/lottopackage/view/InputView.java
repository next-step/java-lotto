package lottopackage.view;

import lottopackage.domain.LottoBall;
import lottopackage.domain.WinningNumberAndBonusBall;

import java.util.*;

public class InputView {
    private final static Scanner SCANNER = new Scanner(System.in).useDelimiter("\\s*\\n\\s*");

    public static int purchaseAmount() {
        System.out.println("구입 금액을 입력해주세요.");
        return SCANNER.nextInt();
    }

    public static int numOfManualLotto() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public static Set<LottoBall> inputManualLotto() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요. (ex) 3, 41, 29, 38, 11, 6");
        return lotto();
    }

    public static WinningNumberAndBonusBall winningNumberAndBonusBall() {
        Set<LottoBall> winningNumber = winningNumber();
        WinningNumberAndBonusBall winningNumberAndBonusBall = new WinningNumberAndBonusBall(winningNumber, bonusBall(winningNumber));
        return winningNumberAndBonusBall;
    }

    private static Set<LottoBall> winningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해주세요. (ex) 3, 41, 29, 38, 11, 6");
        return lotto();
    }

    private static Set<LottoBall> lotto() {
        String lottoString = SCANNER.next();
        String[] lottoStringArray = lottoString.replaceAll(" ", "").split(",");

        Set<LottoBall> lotto = new HashSet<>();
        try {
            lottoStringArrayToLotto(lottoStringArray, lotto);
        } catch (Exception exception) {
            throw new IllegalArgumentException("번호를 잘못 입력했습니다.");
        }
        return lotto;
    }

    private static LottoBall bonusBall(Set<LottoBall> winningNumber) {
        System.out.println("보너스 볼을 입력해주세요.");
        LottoBall bonusBall = new LottoBall(SCANNER.nextInt());
        if (winningNumber.contains(bonusBall)) {
            throw new IllegalArgumentException("지난 주 당첨 번호 중 하나와 보너스 번호가 같습니다.");
        }
        return bonusBall;
    }

    public static void lottoStringArrayToLotto(String[] winningNumberStringArray, Set<LottoBall> winningNumber) {
        for (String number : winningNumberStringArray) {
            winningNumber.add(new LottoBall(Integer.parseInt(number)));
        }
    }
}
