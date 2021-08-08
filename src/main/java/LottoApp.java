import step2.view.InputView;

public class LottoApp {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        int numOfLotto = inputView.requestInput();
        String lastWinningLottoNum = inputView.requestWinningLottoNumber();


    }
}
