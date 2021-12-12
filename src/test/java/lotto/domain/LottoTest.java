package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 추첨에 필요한 단위 `Lotto`에 대한 테스트")
class LottoTest {

    @DisplayName("랜덤 `Lotto` 생성")
    @Test
    void createRandomLottoTest() {
        // when
        Lotto randomLotto = new Lotto();
        // then
        assertThat(randomLotto).isNotNull();
    }

    @DisplayName("커스텀 `Lotto` 생성")
    @Test
    void createCustomLottoTest() {
        // given
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        // when
        Lotto customLotto = new Lotto(lottoNumbers);
        // then
        assertThat(customLotto).isNotNull();
    }
}
