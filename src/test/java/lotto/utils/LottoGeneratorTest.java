package lotto.utils;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {

    @DisplayName("로또번호 자동생성했을시 6자리 숫자가 맞는지")
    @Test
    void lotto_generator_draw_lots() {
        //given
        int expected = 6;

        //when
        List<LottoNumber> lottoNumbers =  LottoGenerator.drawLots();

        //then
        assertThat(lottoNumbers.size()).isEqualTo(expected);
    }
}
