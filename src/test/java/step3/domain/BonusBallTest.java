package step3.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

class BonusBallTest {
    @DisplayName("보너스 볼과 당첨번호가 일치할 경우 에러 발생 여부 확인")
    @Test
    void BonusBallTest() {
        ArrayList<Integer> winningLottoNumberList = new ArrayList<>();
        winningLottoNumberList.add(1);
        winningLottoNumberList.add(2);
        winningLottoNumberList.add(3);
        winningLottoNumberList.add(4);
        winningLottoNumberList.add(5);
        winningLottoNumberList.add(6);
        assertThatThrownBy(() -> BonusBall.copareWithWinningLottoNumbers(4,winningLottoNumberList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 볼과 당첨번호가 일치하지 않을 경우 경우 에러 발생 여부 확인")
    @Test
    void BonusBallTest2() {
        ArrayList<Integer> winningLottoNumberList = new ArrayList<>();
        winningLottoNumberList.add(1);
        winningLottoNumberList.add(2);
        winningLottoNumberList.add(3);
        winningLottoNumberList.add(4);
        winningLottoNumberList.add(5);
        winningLottoNumberList.add(6);
        BonusBall.copareWithWinningLottoNumbers(7, winningLottoNumberList);
    }
}