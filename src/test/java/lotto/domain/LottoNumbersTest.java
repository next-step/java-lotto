package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersTest {

    @Test
    @DisplayName("로또 번호 테스트")
    void getLottoNumbers() {
        // given
        List<Integer> inputNumbers = List.of(1, 2, 3, 4, 5, 6);

        // when
        LottoNumbers lottoNumbers = new LottoNumbers(inputNumbers);

        // then
        assertThat(lottoNumbers.getLottoNumbers()).isEqualTo(inputNumbers);
    }

    @Test
    @DisplayName("로또 번호 벨리데이션 테스트")
    void getLottoNumbers_fail() {

    }
}
