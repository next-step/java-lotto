package lotto;

public class LottoMain {

    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new LottoService());

        lottoController.draw();
    }
}
