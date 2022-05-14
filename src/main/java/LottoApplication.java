import view.InputView;

import java.util.Scanner;

public class LottoApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        System.out.println("cash = " + inputView.scanCashWithAnnouncement());
    }
}
