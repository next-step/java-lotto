package lotto.view;

import lotto.domain.Lottos;

public class OutputView {

    public void askLottoAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public void printLottos(Lottos lottos) {
        System.out.println(lottos.findLottos());
    }
}
