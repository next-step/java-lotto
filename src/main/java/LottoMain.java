import controller.LottoController;
import view.InputView;

public class LottoMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        int price = inputView.inputPrice();

        LottoController controller = new LottoController(price);
        int lottoQuantity = controller.getLottoQuantity();


    }
}
