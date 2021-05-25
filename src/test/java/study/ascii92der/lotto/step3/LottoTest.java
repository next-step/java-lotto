package study.ascii92der.lotto.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @Test
    @DisplayName("로또 번호가 6개인지 확인")
    void lottoNumberCountTest() {
        String lottoString = "3, 5, 11, 16, 32, 38";
        Lotto lotto = new Lotto(lottoString);
        assertThat(lotto.generateNumber().size()).isEqualTo(6);
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
