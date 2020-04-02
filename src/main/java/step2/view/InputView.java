package step2.view;

import step2.domain.LottoGameInfo;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_MONEY_MSG = "금액을 입력해 주세요.";
    private static final String BUY_MESSAGE = " 장을 구매하셨습니다.";

    private LottoGameInfo lottoGameInfo;
    private Scanner scanner;
    private int money;


    public InputView(){
        scanner = new Scanner(System.in);
    }

    public int inputMoney() {
        System.out.println(INPUT_MONEY_MSG);
        money = scanner.nextInt();
        System.out.println(lottoGameInfo.getCountOfLotto() + BUY_MESSAGE);
        return money;
    }
}
