package lotto.step2;

import lotto.step2.controller.Lotto;

public class Application {
    public static void main(String[] args) {
        Lotto lotto = new Lotto();
        lotto.start();
        
        // 갔다와서 ResultView 메서드 정리, 모든 클래스 test 코드 추가
        // LottoTicketTest 에서 일치 번호 개수가 0, 1, 2개일 시 MISS 반환하는 테스트도 추가
    }
}
