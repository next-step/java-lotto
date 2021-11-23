package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void createFail(int wrongNumber) {
        assertThatThrownBy(() -> {
            new LottoNumber(wrongNumber);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("해당 번호의 로또번호는 없습니다.");
    }

    @Test
    void equals() {
        assertThat(new LottoNumber(1)).isEqualTo(new LottoNumber(1));
    }

    @Test
    void getRandomLottoNumber() {
        List<LottoNumber> lotto = LottoNumber.getRandomNumber(Lotto.LOTTO_NUMBER_COUNT);

        assertThat(lotto.size()).isEqualTo(Lotto.LOTTO_NUMBER_COUNT);
    }

}
