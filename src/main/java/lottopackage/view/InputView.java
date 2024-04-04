package lottopackage.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    Scanner scanner = new Scanner(System.in).useDelimiter("\\s*\\n\\s*");

    public int purchaseAmount() {
        System.out.println("구입 금액을 입력해주세요.");
        return scanner.nextInt();
    }

    public void winningNumberStringArrayToWinningNumber (String[] winningNumberStringArray, List<Integer> winningNumber) {
        for (String number : winningNumberStringArray) {
            winningNumber.add(Integer.valueOf(number));
        }
    }

    public List<Integer> winningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해주세요. (ex) 3, 41, 29, 38, 11, 6");

        String winningNumberString = scanner.next();
        String[] winningNumberStringArray = winningNumberString.replaceAll(" ", "").split(",");

        List<Integer> winningNumber = new ArrayList<>();
        try {
            winningNumberStringArrayToWinningNumber(winningNumberStringArray, winningNumber);
        }
        catch (Exception exception) {
            throw new IllegalArgumentException("당첨 번호를 잘못 입력했습니다.");
        }

        return winningNumber;
    }
}
