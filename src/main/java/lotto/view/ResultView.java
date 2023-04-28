package lotto.view;

import lotto.domain.LottoInfo;

public class ResultView {
    public void getAllAvailableNumbers() {
        System.out.println("선택 가능한 로또 번호는 다음과 같습니다.");
        for (int number : LottoInfo.NUMBER_RANGE) {
            System.out.printf("%d ", number);
        }
    }
}
