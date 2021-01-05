package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberRepositoryTest {
    @DisplayName("수동으로 구매할 번호 입력")
    @Test
    void of() {
        List<LottoNumber> lottoNumbers = LottoNumberRepository.of("8,21,23,41,42,43");
        assertThat(lottoNumbers.size()).isEqualTo(6);
    }
}