package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningNumbersTest {
    @Test
    void 로또번호_매칭_테스트() {
        // given
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        int count = winningNumbers.countNumberMatching(lotto);

        // then
        assertThat(count).isEqualTo(6);
    }
}