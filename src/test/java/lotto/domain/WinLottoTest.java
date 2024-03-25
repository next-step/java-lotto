package lotto.domain;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("도메인 WinLotto 테스트")
class WinLottoTest {

    @DisplayName("로또 번호 일치 개수 테스트")
    @Test
    void getFeatNumberCount() {
        Lotto givenLotto = Lotto.ofNumbers(List.of(1, 2, 3, 4, 5, 6));
        WinLotto winLotto = WinLotto.ofNumbers(List.of(1, 5, 6, 7, 8, 9), 5);

        int result = winLotto.getFeatNumberCount(givenLotto);
        assertThat(result).isEqualTo(3);
    }
}
