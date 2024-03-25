import controller.LottoController;
import view.LottoInput;

public class LottoApplication {
    public static void main(String[] args) {

        LottoInput lottoInput = new LottoInput();
        LottoController lottoController = new LottoController();

        lottoController.run(lottoInput.buyCash());
    }
}
