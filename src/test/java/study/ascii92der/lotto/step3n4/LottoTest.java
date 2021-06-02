package study.ascii92der.lotto.step3n4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    @DisplayName("로또 번호가 6개인지 확인")
    void lottoNumberCountTest() {
        List<Integer> lottoNumbers = new ArrayList<>(Arrays.asList(3, 5, 11, 32, 38));

        assertThatThrownBy(() -> new Lotto(lottoNumbers)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Lotto Number count is wrong");

    }

    @Test
    @DisplayName("로또 중복 번호 확인 테스트")
    void duplicateNumberTest() {
        List<Integer> lottoNumbers = new ArrayList<>(Arrays.asList(3, 5, 3, 16, 32, 38));

        assertThatThrownBy(() -> new Lotto(lottoNumbers)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("This Numbers has duplicate number");

    }
}
