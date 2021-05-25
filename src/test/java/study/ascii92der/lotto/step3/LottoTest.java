package study.ascii92der.lotto.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    @DisplayName("로또 번호가 6개인지 확인")
    void lottoNumberCountTest() {
        String lottoString = "3, 5, 11, 32, 38";

        assertThatThrownBy(() -> {
            new Lotto(lottoString);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Lotto Number count is wrong");

    }

    @Test
    @DisplayName("로또 중복 번호 확인 테스트")
    void duplicateNumberTest() {
        String lottoString = "3, 5, 3, 16, 32, 38";

        assertThatThrownBy(() -> {
            new Lotto(lottoString);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("This Numbers has duplicate number");

    }
}
