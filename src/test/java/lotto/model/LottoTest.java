package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LottoTest {
    @Test
    @DisplayName("기본 생성 테스트")
    public void create() {
        Lotto lotto = new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(lotto).isNotNull();
    }

    @Test
    @DisplayName("로또는 6개의 로또 숫자로 이루어져 있다")
    public void validate() {
        assertThatThrownBy(() -> {
            new Lotto(new LottoNumbers(Arrays.asList(1, 2)));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}