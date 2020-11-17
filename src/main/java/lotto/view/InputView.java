package lotto.view;

public class InputView {

    private final static String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private final static String INPUT_WINNER_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    public void printInputAmountMessage(){
        System.out.println(INPUT_AMOUNT_MESSAGE);
    }

    public void printInputWinnerNumbersMessage(){
        System.out.println(INPUT_WINNER_NUMBERS_MESSAGE);
    }

}
