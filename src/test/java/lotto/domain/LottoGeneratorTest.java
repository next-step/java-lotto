package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    @Test
    @DisplayName("랜덤 숫자 6개를 생성한다.")
    void create_random_numbers() {
        // given
        LottoGenerator generator = new LottoGenerator(numbers -> given());

        // when
        List<LottoNumber> result = generator.createLotto(LottoNumber.allNumbers());

        // then
        assertThat(result).isEqualTo(getExpected());
    }

    private List<LottoNumber> given() {
        return List.of(
                LottoNumber.valueOf(1),
                LottoNumber.valueOf(21),
                LottoNumber.valueOf(26),
                LottoNumber.valueOf(31),
                LottoNumber.valueOf(40),
                LottoNumber.valueOf(42)
        );
    }

    private List<LottoNumber> getExpected() {
        return List.of(
                LottoNumber.valueOf(1),
                LottoNumber.valueOf(21),
                LottoNumber.valueOf(26),
                LottoNumber.valueOf(31),
                LottoNumber.valueOf(40),
                LottoNumber.valueOf(42)
        );
    }
}