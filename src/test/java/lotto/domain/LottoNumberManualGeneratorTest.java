package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberManualGeneratorTest {

    @DisplayName("로또번호를 수동으로 구매할 때 요청 횟수 만큼 요청한 로또번호를 각각 받는다.")
    @Test
    void lotto_manual_generator_draw_lots() {
        //given
        final int lottoCount = 2;
        final List<Lotto> expected = Arrays.asList(
                new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))),
                new Lotto(Arrays.asList(new LottoNumber(5), new LottoNumber(6), new LottoNumber(11),
                        new LottoNumber(22), new LottoNumber(33), new LottoNumber(44))));
        final LottoNumberGenerator lottoNumberManualGenerator = new LottoNumberManualGenerator(
                Arrays.asList("1,2,3,4,5,6", "5,6,11,22,33,44"));

        //when
        final List<Lotto> lottoNumbers = lottoNumberManualGenerator.drawLots(lottoCount);

        //then
        assertThat(lottoNumbers.size()).isEqualTo(lottoCount);
        assertThat(lottoNumbers).containsAll(expected);
    }
}