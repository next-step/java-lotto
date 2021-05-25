package study.ascii92der.lotto.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @Test
    @DisplayName("로또 번호가 6개인지 확인")
    void lottoNumberCountTest() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(lottoNumbers);
        assertThat(lotto.generateNumber().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 중복 번호 확인 테스트")
    void duplicateNumberTest() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 1);

        assertThatThrownBy(() -> {
            new Lotto(lottoNumbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("This Numbers has duplicate number");

    }
}
