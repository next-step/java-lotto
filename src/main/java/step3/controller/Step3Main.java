package step3.controller;


import cmm.util.InputUtil;
import step3.domain.*;
import step3.view.PrintResult;

import java.util.List;

public class Step3Main {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame(InputUtil.returnInteger("구입금액을 입력해 주세요."));
        lottoGame.playLottoGame();
    }
}
