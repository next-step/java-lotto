package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberAutoGeneratorTest {

    @DisplayName("로또번호를 자동으로 구매할 때 요청 횟수 만큼 6개의 로또번호를 각각 받는다.")
    @Test
    void lotto_auto_generator_draw_lots() {
        //given
        final int lottoCount = 10;
        final int expected = 6;
        final LottoNumberGenerator lottoNumberAutoGenerator = new LottoNumberAutoGenerator();

        //when
        final List<Lotto> lottoNumbers = lottoNumberAutoGenerator.drawLots(lottoCount);

        //then
        assertThat(lottoNumbers.size()).isEqualTo(lottoCount);
        for (final Lotto lottoNumber : lottoNumbers) {
            assertThat(lottoNumber.size()).isEqualTo(expected);
        }
    }
}
