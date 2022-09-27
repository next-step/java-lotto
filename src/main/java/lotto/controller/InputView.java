package lotto.controller;


public class InputView {

    private static String LOTTO_BUY_MONEY_QST = "구입금액을 입력해 주세요.";

    private static String BUY_NUMBER = "%d개를 구매했습니다. \n";

    private static String WINNING_NUMBER_QST ="지난 주 당첨 번호를 입력해 주세요.";

    static void printMoneyQst(){
        System.out.println(LOTTO_BUY_MONEY_QST);
    }

    static void printLottoBuyMsg(int lottoNumber){
        System.out.printf(BUY_NUMBER,lottoNumber);
    }

    static void printWinningNumberQst(){
        System.out.println(WINNING_NUMBER_QST);
    }

}