package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinNumberTest {
    @Test
    void 당첨번호_리스트_생성() {
        assertThat(new WinNumber().createWinNumbers("1, 2, 3, 4, 5, 6"))
                .containsExactlyInAnyOrder(1, 2, 3, 4, 5, 6);
    }

    @Test
    void 당첨번호_리스트_길이() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinNumber().createWinNumbers("1, 2, 3, 4, 5, 6, 7"))
                .withMessageMatching("당첨 번호는 6개여야 합니다.");
    }
}
