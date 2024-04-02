package lottopackage.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    Scanner scanner = new Scanner(System.in);

    public int purchaseAmount() {
        return scanner.nextInt();
    }

    public List<Integer> winningNumber() {
        String[] winningNumberString = scanner.nextLine().trim().split(",");
        List<Integer> winningNumber = new ArrayList<>();
        for (String number : winningNumberString) {
            winningNumber.add( Integer.valueOf(number) );
        }
        return winningNumber;
    }
}
