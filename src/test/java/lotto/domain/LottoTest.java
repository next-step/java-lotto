package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoTest {

    @DisplayName("입력받은 로또 번호를 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void create_lotto(final int index) {

        final Lotto lotto = Lotto.from("1, 2, 3, 4, 5, 6");
        final List<Number> result = lotto.getLotto();

        assertThat(result).contains(new Number(index));
    }
}
