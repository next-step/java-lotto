package lotto.view;

import lotto.model.LottoPayment;

import java.util.Scanner;

public class InputView {

    private final String INTRO_MESSAGE = "구입금액을 입력해 주세요.";
    private final String LAST_LOTTO_WINNER_NUMBER_INPUT_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private final String DELIMITER = ",";
    private Scanner sc = new Scanner(System.in);

    public InputView() {
        System.out.println(INTRO_MESSAGE);
    }
    public int displayIntroInputUI(){
        int LottoCount = new LottoPayment().pay(sc.nextLine());
        displayPayLottoCountUI(LottoCount);
        return LottoCount;
    }

    public void displayPayLottoCountUI(int count){
        System.out.println(count + "개를 구매했습니다.");
    }

    public String[] displayLastLottoNumberInputUI(){
        System.out.println(LAST_LOTTO_WINNER_NUMBER_INPUT_MESSAGE);
        return sc.nextLine().split(DELIMITER);
    }

}
