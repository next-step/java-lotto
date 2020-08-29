package step4.controller;


import cmm.util.InputUtil;
import step4.domain.LottoGame;

public class Step4Main {
    public static void main(String[] args) {
        int price = InputUtil.returnInteger("구입금액을 입력해 주세요.");
        int manualQuantity = InputUtil.returnInteger("수동으로 구매할 로또 수를 입력해 주세요.");
        LottoGame lottoGame = new LottoGame(price, manualQuantity);
        lottoGame.playLottoGame();
    }
}
