package automaticlotto.main;

import automaticlotto.controller.AutoLottoController;

public class Main {
    public static void main(String[] args) {
        AutoLottoController autoLottoController = new AutoLottoController();
        autoLottoController.startLotto();
    }
}
