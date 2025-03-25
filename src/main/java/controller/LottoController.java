package controller;

import service.LottoService;

public class LottoController {
    public static void main(String[] args) {
        LottoService lottoService = new LottoService();
        lottoService.play();
    }
}
