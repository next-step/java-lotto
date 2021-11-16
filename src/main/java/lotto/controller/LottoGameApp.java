package lotto.controller;

import lotto.model.PurchaseInfo;
import lotto.view.InputView;

public class LottoGameApp {

    public static void main(String[] args) {
        try {
            int amount = InputView.getIntValue("구입금액을 입력해 주세요.");
            PurchaseInfo purchaseInfo = new PurchaseInfo(amount);
        } catch (Exception ex) {
            System.out.println(ex.getMessage() + " 게임을 종료합니다.");
        }
    }

}
