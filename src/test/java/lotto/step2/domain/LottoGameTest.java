package lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {

    @DisplayName("LottoGame 내에 로또가 정상적으로 생성되는지 테스트")
    @ParameterizedTest
    @CsvSource(value = {"5:5", "10:10", "14:14"}, delimiter = ':')
    void lottoGame_of(int input, int expected) {
        LottoGame lottoGame = LottoGame.of(input);
        assertThat(lottoGame.getLottos().getSize()).isEqualTo(expected);
    }
}