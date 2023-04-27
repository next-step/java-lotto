package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberGroupTest {

    private final LottoNumberGroup lottoNumberGroup = new LottoNumberGroup();

    @Test
    @DisplayName("6개의 로또번호를 모으는 테스트")
    void aggregateLottoNumber() {

        assertThat(lottoNumberGroup.aggregateLottoNumber()).hasSize(6);
    }
}