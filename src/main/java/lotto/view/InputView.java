package lotto.view;

import java.util.Scanner;

public class InputView {

    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public int readPurchaseAmount() {
        return getNumberFromStdin("구입금액을 입력해 주세요.");
    }

    public String readWinningNumber() {
        return getStringFromStdin("지난 주 당첨 번호를 입력해 주세요.");
    }

    public int readBonusNumber() {
        return getNumberFromStdin("보너스 볼을 입력해 주세요.");
    }

    private String getStringFromStdin(String displayText) {
        return getFromStdin(displayText);
    }

    private int getNumberFromStdin(String displayText) {
        String value = getFromStdin(displayText);
        return Integer.valueOf(value);
    }

    private String getFromStdin(String displayText) {
        System.out.println(displayText);
        return scanner.nextLine();
    }

    @Override
    protected void finalize() throws Throwable {
        this.scanner.close();
        super.finalize();
    }

}
