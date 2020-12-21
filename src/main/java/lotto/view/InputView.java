package lotto.view;

public class InputView {

    private static final String INPUT_MONEY_INFO = "구입 금액을 입력해 주세요.";
    private static final String INPUT_LAST_WINNINGNUMBER = "지난 주 당첨 번호를 입력해 주세요. ";

    private InputView(){}

    public static void showInputMoneyInfo(){
        System.out.println(INPUT_MONEY_INFO);
    }

    public static void showInputLastWinningNumber() {
        System.out.println(INPUT_LAST_WINNINGNUMBER);
    }
}
