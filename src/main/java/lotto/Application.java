package lotto;

import lotto.core.LottoController;

public class Application {

    public static void main(String[] args) {
        LottoController controller = new LottoController();

        //1. 구매금액 입력 및 로또티켓들 생성
        controller.getTickets();

        //2. 당첨번호 입력
        controller.getWinningNumbers();

        //3. 당첨통계 생성 및 출력
        controller.getLottoResult();
    }
}
