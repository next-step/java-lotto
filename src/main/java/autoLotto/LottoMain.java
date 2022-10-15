package autoLotto;

public class LottoMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        int amount = inputView.inputAmount();
        inputView.inputNumbers();

        System.out.println(amount);

    }
}
