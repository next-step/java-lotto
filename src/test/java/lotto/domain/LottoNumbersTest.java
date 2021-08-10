package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersTest {
    @Test
    @DisplayName("로또 자동 1개(번호 6개)생성 성공 테스트")
    void 로또_랜덤_번호_생성_테스트() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        assertThat(lottoNumbers.generateRandomNumbers().size()).isEqualTo(6);
    }
}
