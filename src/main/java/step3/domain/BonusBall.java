package step3.domain;

import java.util.List;

public class BonusBall {
    private Lotto number;

    public BonusBall(int number,List<Integer> winningLottoNumberList) {
        compareWithWinningLottoNumbers(number, winningLottoNumberList);
        this.number = new Lotto(number);
    }

    public int getNumber() {
        return number.getNumber();
    }

    public void compareWithWinningLottoNumbers(int bonusBallNumber, List<Integer> winningLottoNumberList) {
        if (winningLottoNumberList.contains(bonusBallNumber)) {
            throw new IllegalArgumentException("보너스 볼의 번호는 당첨 번호와 일치할 수 없습니다.");
        }
    }
}
