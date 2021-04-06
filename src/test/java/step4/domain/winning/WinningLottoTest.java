package step4.domain.winning;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {

    @DisplayName("WinningLotto 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        String sentence = "1, 2, 3, 4, 5, 6";
        int money = 1000;

        // when
        WinningLotto winningLotto = WinningLotto.from(sentence, money);

        // then
        assertThat(winningLotto).isNotNull();
    }
}