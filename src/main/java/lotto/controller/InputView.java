package lotto.controller;


public class InputView {

    private static String LOTTO_BUY_MONEY_QST = "구입금액을 입력해 주세요.";

    private static String BUY_NUMBER = "%d개를 구매했습니다. \n";

    static void printMoneyQst(){
        System.out.println(LOTTO_BUY_MONEY_QST);
    }

    static void printLottoBuyMsg(int lottoNumber){
        System.out.printf(BUY_NUMBER,lottoNumber);
    }

}