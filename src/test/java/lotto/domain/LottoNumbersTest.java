package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class LottoNumbersTest {

    @DisplayName("중복되지 않은 6개의 숫자 리스트를 반환한다.")
    @Test
    void randomListTest() {
        List<LottoNumber> randomList = LottoNumbers.randomList();

        assertThat(randomList.size()).isEqualTo(6);
    }
}
