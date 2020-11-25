package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

class LottoTest {

    @Test
    void 로또_번호_1장_생성() {
        // given
        Lotto lotto = new Lotto();

        // when
        Set<Integer> lottoAutoNumber = lotto.createAuto();

        // then
        Assertions.assertThat(lottoAutoNumber.size()).isEqualTo(6);
    }

    @Test
    void 로또_번호_여러장_생성() {

    }
}