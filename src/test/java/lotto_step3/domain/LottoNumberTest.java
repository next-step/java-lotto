package lotto_step3.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class LottoNumberTest {

    @DisplayName("중복되지 않은 6개의 숫자 리스트를 반환한다.")
    @Test
    void randomListTest() {
        List<Integer> randomList = LottoNumber.randomList();

        assertThat(randomList.size()).isEqualTo(6);
    }

    @DisplayName("1-45 사이의 숫자가 아닐경우 IllegalArgumentException을 던진다.")
    @Test
    void checkTest() {
        assertThatThrownBy(() -> LottoNumber.check(Set.of(1, 45, 2, 3, 4, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}