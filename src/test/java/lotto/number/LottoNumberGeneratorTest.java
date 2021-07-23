package lotto.number;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 번호 생성기 클래스")
class LottoNumberGeneratorTest {

    @DisplayName("로또 번호 생성기는 로또 번호 그룹을 생성하여 반환한다.")
    @Test
    void generate() {
        assertThat(LottoNumberGenerator.generate()).isInstanceOf(LottoNumbers.class);
    }

}
