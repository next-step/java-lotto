package lottopackage.view;

import lottopackage.domain.LottoBall;

import java.util.*;

public class InputView {
    private final static Scanner SCANNER = new Scanner(System.in).useDelimiter("\\s*\\n\\s*");

    public static int purchaseAmount() {
        System.out.println("구입 금액을 입력해주세요.");
        return SCANNER.nextInt();
    }

    public static Set<LottoBall> winningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해주세요. (ex) 3, 41, 29, 38, 11, 6");

        String winningNumberString = SCANNER.next();
        String[] winningNumberStringArray = winningNumberString.replaceAll(" ", "").split(",");

        Set<LottoBall> winningNumber = new HashSet<>();
        try {
            winningNumberStringArrayToWinningNumber(winningNumberStringArray, winningNumber);
        } catch (Exception exception) {
            throw new IllegalArgumentException("당첨 번호를 잘못 입력했습니다.");
        }

        return winningNumber;
    }

    public static void winningNumberStringArrayToWinningNumber(String[] winningNumberStringArray, Set<LottoBall> winningNumber) {
        for (String number : winningNumberStringArray) {
            winningNumber.add( new LottoBall(Integer.parseInt(number)));
        }
    }
}
