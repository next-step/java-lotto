package lottopackage.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    Scanner scanner = new Scanner(System.in);

    public int purchaseAmount() {
        System.out.println("구입 금액을 입력해주세요.");
        return scanner.nextInt();
    }
    
    public List<Integer> winningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        String[] winningNumberString = scanner.nextLine().trim().split(",");
        List<Integer> winningNumber = new ArrayList<>();
        for (String number : winningNumberString) {
            winningNumber.add( Integer.valueOf(number) );
        }
        return winningNumber;
    }
}
