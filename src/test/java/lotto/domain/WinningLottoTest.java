package lotto.domain;

import lotto.util.LottoNumberParser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class WinningLottoTest {
    static Stream<Arguments> provideLottoNumbers() {
        return Stream.of(
                Arguments.of("1, 2, 3, 4, 5, 6", LottoRank.FIRST),
                Arguments.of("1, 2, 3, 4, 5, 13", LottoRank.SECOND_BONUS),
                Arguments.of("1, 2, 3, 4, 5, 7", LottoRank.SECOND),
                Arguments.of("1, 2, 3, 4, 8, 9", LottoRank.THIRD),
                Arguments.of("1, 2, 3, 10, 11, 12", LottoRank.FOURTH)
        );
    }

    @ParameterizedTest
    @MethodSource("provideLottoNumbers")
    public void 일치하는_숫자의_개수(String numbers, LottoRank expected) {
        LottoNumbers lottoNumbers = new LottoNumbers(numbers);
        LottoNumbers winningLottoNumbers = new LottoNumbers(1, 2, 3, 4, 5, 6);
        LottoNumber bonusNumber = new LottoNumber(13);
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, bonusNumber);

        assertThat(winningLotto.getMatchedRank(lottoNumbers)).isEqualTo(expected);
    }

    @Test
    public void 보너스_숫자_중복() {
        assertThatThrownBy(() -> new WinningLotto("1, 2, 3, 4, 5, 6", "1")).isInstanceOf(IllegalArgumentException.class);
    }
}
