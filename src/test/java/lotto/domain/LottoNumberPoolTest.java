package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberPoolTest {

    @Test
    @DisplayName("생성되어있는 로또 풀에서 생성될때 NotEmpty, Size, 호출마다 다른 배열인지 테스트")
    void checkByGenerating() {
        List<LottoNumber> first = LottoNumberPool.generateLottoNumbers();
        List<LottoNumber> second = LottoNumberPool.generateLottoNumbers();

        assertThat(first).isNotEmpty();
        assertThat(first).hasSize(6);
        assertThat(first).isNotEqualTo(second);
    }
}