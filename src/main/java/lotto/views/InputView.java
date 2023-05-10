package lotto.views;

import lotto.Lottos;

public class InputView {

    public static void purchaseInputView() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void purchaseResultView(Lottos lottos) {
        System.out.println(lottos.getLottoCount() + "개를 구매했습니다.");
        lottos.printLottos();
    }

    public static void winningInputView() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }
}
