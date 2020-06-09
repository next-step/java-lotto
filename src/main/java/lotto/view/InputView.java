package lotto.view;

public class InputView {

    private final String INTRO_MESSAGE = "구입금액을 입력해 주세요.";
    private final String LAST_LOTTO_WINNER_NUMBER_INPUT_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 볼을 입력해 주세요.";
    public final String DELIMITER = ",";

    public InputView() {
        System.out.println(INTRO_MESSAGE);
    }
    public void displayIntroInputUI(int inputPay){
        displayPayLottoCountUI(inputPay);
    }

    public void displayPayLottoCountUI(int count){
        System.out.println(count + "개를 구매했습니다.");
    }

    public void displayLastLottoNumberInputUI(){
        System.out.println(LAST_LOTTO_WINNER_NUMBER_INPUT_MESSAGE);
    }

    public void displayBonusLottoNumberInputUI(){
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
    }

}
