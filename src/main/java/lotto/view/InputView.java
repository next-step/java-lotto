package lotto.view;

import java.util.Scanner;

public class InputView {

    private final String INTRO_MESSAGE = "구입금액을 입력해 주세요.";
    private final String LAST_LOTTO_WINNER_NUMBER_INPUT_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 볼을 입력해 주세요.";
    public final String DELIMITER = ",";
    Scanner sc = new Scanner(System.in);

    public String displayLottoIntro() {
        System.out.println(INTRO_MESSAGE);
        return sc.nextLine();
    }
    public void displayIntroInputUI(int inputPay){
        displayPayLottoCountUI(inputPay);
    }

    public void displayPayLottoCountUI(int count){
        System.out.println(count + "개를 구매했습니다.");
    }

    public String[] displayLastLottoNumberInputUI(){
        System.out.println(LAST_LOTTO_WINNER_NUMBER_INPUT_MESSAGE);
        return sc.nextLine().split(DELIMITER);
    }

    public int displayBonusLottoNumberInputUI(){
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
        return sc.nextInt();
    }

}
