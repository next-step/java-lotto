package step3.domain;

import java.util.List;

public class BonusBall {

    static public void copareWithWinningLottoNumbers(int bonusBallNumber, List<Integer> winningLottoNumberList) {
        if (winningLottoNumberList.contains(bonusBallNumber)) {
            throw new IllegalArgumentException("보너스 볼의 번호는 당첨 번호와 일치할 수 없습니다.");
        }
    }
}
