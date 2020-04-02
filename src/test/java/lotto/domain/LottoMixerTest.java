package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMixerTest {

    @Test
    @DisplayName("생성되어있는 로또 믹서에서 섞일때 NotEmpty, Size, 호출마다 다른 배열인지 테스트")
    void checkByGenerating() {
        List<LottoNumber> first = LottoMixer.mixLottoNumbers();
        List<LottoNumber> second = LottoMixer.mixLottoNumbers();

        assertThat(first).isNotEmpty();
        assertThat(first).hasSize(6);
        assertThat(first).isNotEqualTo(second);
    }
}