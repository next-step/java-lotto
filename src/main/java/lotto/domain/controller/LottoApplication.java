package lotto.domain.controller;

import lotto.domain.view.InputView;
import util.StringUtil;

public class LottoApplication {

    public static void main(String[] args) {
        String inputMoney = InputView.inputBuyAmount();
        StringUtil.parseStringToInt(inputMoney);
    }
}
