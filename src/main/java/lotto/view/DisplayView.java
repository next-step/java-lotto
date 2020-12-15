package calculator.view;

public class DisplayView {

    private static final String INPUT_MONEY_INFO = "구입 금액을 입력해 주세요.";
    private static final String NUMBER_OF_LOTTO = "개를 구매 했습니다.";

    public void showInputMoneyInfo(){
        System.out.println(INPUT_MONEY_INFO);
    }

    public void exchangeLottoMsg( int numberOfLotto){
        System.out.println(numberOfLotto + NUMBER_OF_LOTTO);
    }
}
