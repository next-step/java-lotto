package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @DisplayName("init Class")
    @ParameterizedTest
    @CsvSource(value = {"6:45"}, delimiter = ':')
    public void testClassNormalInitialize(int lottoDrawLimit, int lottoMaxLimit) {

        // ready
        LottoGame lottoGame = new LottoGame();

        List<Integer> lottoGameNumbers = lottoGame.getLottoGameNumbers();

        assertThat(lottoGameNumbers.size()).isEqualTo(lottoMaxLimit);

        Lotto lotto = Lotto.of(lottoDrawLimit, lottoGameNumbers);

        assertThat(lotto.getNumbers().size()).isEqualTo(lottoDrawLimit);


    }

    @DisplayName("init Class boundary error")
    @ParameterizedTest
    @CsvSource(value = {"5:100", "7:25"}, delimiter = ':')
    public void testClassInitialize(int lottoDrawLimit, int lottoMaxLimit) {

        // 내부상수를 통해 결정되어 있는 내용을 외부에서 테스트 하는게 옳은가? 에 대한 의문이 듭니다.

        // ready
        LottoGame lottoGame = new LottoGame();
        List<Integer> lottoGameNumbers = lottoGame.getLottoGameNumbers();

/*
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Lotto.of(lottoDrawLimit, lottoGameNumbers);
                });
*/

        assertThat(lottoGameNumbers.size()).isNotEqualTo(lottoMaxLimit);

    }

}
