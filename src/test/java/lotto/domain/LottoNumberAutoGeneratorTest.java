package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberAutoGeneratorTest {

    @DisplayName("로또번호는 자동생성될 때 6개의 로또번호를 받는다.")
    @Test
    void lotto_generator_draw_lots() {
        //given
        final int expected = 6;
        final LottoNumberAutoGenerator lottoNumberAutoGenerator = new LottoNumberAutoGenerator();

        //when
        final List<LottoNumber> lottoNumbers = lottoNumberAutoGenerator.drawLots();

        //then
        assertThat(lottoNumbers.size()).isEqualTo(expected);
    }
}
