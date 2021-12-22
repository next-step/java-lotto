package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {
    @DisplayName("당첨 번호 생성 성공")
    @Test
    void create() {
        assertThat(new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 45)).isInstanceOf(WinningLotto.class);
    }

    @DisplayName("당첨 번호 생성 실패 - 보너스 번호는 당첨 번호 6자리와 중복될 수 없다.")
    @Test
    void exception() {
        assertThatThrownBy(() -> new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스 번호는 기존 lotto 당첨 번호와 중복될 수 없습니다.");
    }

    @DisplayName("match 함수는 prizeNumbers 와 일치하는 수를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1, 6", "2, 5", "3, 4", "4, 3", "5, 2", "6, 1", "7, 0"})
    void match(int number, int expect) {
        List<Integer> prizeNumbers = Arrays.asList(number, number + 1, number + 2, number + 3, number + 4, number + 5);
        assertThat(new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 45).match(new Lotto(prizeNumbers))).isEqualTo(expect);
    }

    @DisplayName("matchBonusNumber 함수는 매개 변수로 전달 받은 로또가 보너스 번호를 포함하는지 boolean값을 반환한다.")
    @Test
    void matchBonusNumber() {
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 7), 6);
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(winningLotto.matchBonusNumber(lotto)).isTrue();
    }
}
