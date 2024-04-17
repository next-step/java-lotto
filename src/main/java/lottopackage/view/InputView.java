package lottopackage.view;

import lottopackage.domain.*;
import lottopackage.vo.Lotto;
import lottopackage.vo.LottoBall;
import lottopackage.vo.LottoBalls;
import lottopackage.vo.NumberOfManualLotto;

import java.util.*;

public class InputView {
    private final static Scanner SCANNER = new Scanner(System.in).useDelimiter("\\s*\\n\\s*");

    public static int purchaseAmount() {
        System.out.println("구입 금액을 입력해주세요.");
        return SCANNER.nextInt();
    }

    /* (inputView에서 수동으로 구매한 로또를 생성하고 List<Lotto>로 전달함) */
    public static List<Lotto> manualLottos() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        NumberOfManualLotto numberOfManualLotto = new NumberOfManualLotto(SCANNER.nextInt());

        System.out.println("수동으로 구매할 번호를 입력해 주세요. (ex) 3, 41, 29, 38, 11, 6");
        List<Lotto> manualLottos = new ArrayList<>();

        for (int i = 0; i < numberOfManualLotto.getNumberOfManualLotto(); i++) {
            manualLottos.add(new Lotto(inputLottoBalls()));
        }

        return manualLottos;
    }

    public static WinningNumberAndBonusBall winningNumberAndBonusBall() {
        WinningNumberAndBonusBall winningNumberAndBonusBall = new WinningNumberAndBonusBall(winningNumber(), bonusBall());
        return winningNumberAndBonusBall;
    }

    private static LottoBalls winningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해주세요. (ex) 3, 41, 29, 38, 11, 6");
        return inputLottoBalls();
    }

    private static LottoBall bonusBall() {
        System.out.println("보너스 볼을 입력해주세요.");
        LottoBall bonusBall = new LottoBall(SCANNER.nextInt());
        return bonusBall;
    }

    private static LottoBalls inputLottoBalls() {
        String lottoString = SCANNER.next();
        String[] lottoStringArray = lottoString.replaceAll(" ", "").split(",");

        Set<LottoBall> lottoBallSet = new HashSet<>();
        try {
            lottoStringArrayToLotto(lottoStringArray, lottoBallSet);
        } catch (Exception exception) {
            throw new IllegalArgumentException("번호를 잘못 입력했습니다.");
        }

        LottoBalls lottoBalls = new LottoBalls(lottoBallSet);
        return lottoBalls;
    }

    public static void lottoStringArrayToLotto(String[] winningNumberStringArray, Set<LottoBall> winningNumber) {
        for (String number : winningNumberStringArray) {
            winningNumber.add(new LottoBall(Integer.parseInt(number)));
        }
    }
}
