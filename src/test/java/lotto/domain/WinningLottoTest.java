package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class WinningLottoTest {
    static Stream<Arguments> provideLottoNumbers() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), LottoRank.FIRST),
                Arguments.of(List.of(1, 2, 3, 4, 5, 13), LottoRank.SECOND_BONUS),
                Arguments.of(List.of(1, 2, 3, 4, 5, 7), LottoRank.SECOND),
                Arguments.of(List.of(1, 2, 3, 4, 8, 9), LottoRank.THIRD),
                Arguments.of(List.of(1, 2, 3, 10, 11, 12), LottoRank.FOURTH)
        );
    }

    @ParameterizedTest
    @MethodSource("provideLottoNumbers")
    public void 일치하는_숫자의_개수(List<Integer> numbers, LottoRank expected) {
        LottoNumbers lottoNumbers = new LottoNumbers(numbers);
        LottoNumbers winningLottoNumbers = new LottoNumbers(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = new LottoNumber(13);
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, bonusNumber);

        assertThat(winningLotto.getMatchedRank(lottoNumbers)).isEqualTo(expected);
    }
}
