package step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LastWinningLottoNumberCheckerTest {
    @DisplayName("사용자에게 입력 받은 당첨 번호의 갯수가 6개인지 확인")
    @Test
    void validCountOfLottoNum() {
        String lastWinningLottoNum1 = "1, 2, 3, 4, 5, 6";
        String lastWinningLottoNum2 = "1, 2, 3, 4, 5";
        String lastWinningLottoNum3 = "1, 2, 3, 4, 5, 6, 7";
        String lastWinningLottoNum4 = "1,2,3,4,5,6";
        LastWinningLottoNumberChecker lastWinningLottoNumberChecker = new LastWinningLottoNumberChecker(lastWinningLottoNum1);
        lastWinningLottoNumberChecker.validateCountOfLotto(lastWinningLottoNum1);
        Assertions.assertThatThrownBy(() -> lastWinningLottoNumberChecker.validateCountOfLotto(lastWinningLottoNum2)).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> lastWinningLottoNumberChecker.validateCountOfLotto(lastWinningLottoNum3)).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> lastWinningLottoNumberChecker.validateCountOfLotto(lastWinningLottoNum4)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자에게 입력 받은 당첨 번호가 1과 46 사이의 숫자인지 확인")
    @Test
    void validatePositiveLottoNum() {
        String lastWinningLottoNum1 = "1, 2, 3, 4, 5, 6";
        ArrayList<Integer> lastWinningLottoNum2 = new ArrayList<>(Arrays.asList(1, 46));
        ArrayList<Integer> lastWinningLottoNum3 = new ArrayList<>(Arrays.asList(0));
        ArrayList<Integer> lastWinningLottoNum4 = new ArrayList<>(Arrays.asList(47));
        ArrayList<Integer> lastWinningLottoNum5 = new ArrayList<>(Arrays.asList(-1));
        LastWinningLottoNumberChecker lastWinningLottoNumberChecker = new LastWinningLottoNumberChecker(lastWinningLottoNum1);
        lastWinningLottoNumberChecker.lottoLoop(lastWinningLottoNum2);
        Assertions.assertThatThrownBy(() -> lastWinningLottoNumberChecker.lottoLoop(lastWinningLottoNum3)).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> lastWinningLottoNumberChecker.lottoLoop(lastWinningLottoNum4)).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> lastWinningLottoNumberChecker.lottoLoop(lastWinningLottoNum5)).isInstanceOf(IllegalArgumentException.class);

    }
}