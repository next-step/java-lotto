package lotto;

import org.assertj.core.internal.bytebuddy.asm.Advice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    @DisplayName("로또는 6개의 번호가 있다")
    public void lottoHas6NumbersTest() {
        LottoNumbers lottoNumbers = new LottoNumbers(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(lottoNumbers);
        assertThat(lotto.getNumbers()).isEqualTo(lottoNumbers);
    }


    @ParameterizedTest(name = "로또번호 : {1}, 결과 : {2}")
    @DisplayName("로또 등수 반환한다")
    @MethodSource("lottoNumberAndWinningNumber")
    public void matchLottoNumberRankTest(List<Integer> lottoNums, List<Integer> winningNums, Rank rank) {

        Lotto lotto = new Lotto( new LottoNumbers(lottoNums));

        LottoResult sut = lotto.match(new LottoNumbers(winningNums));

        assertThat(sut.getRank()).isEqualTo(rank);
    }


    static Stream<Arguments> lottoNumberAndWinningNumber() {
        return Stream.of(
            Arguments.arguments(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 6), Rank.FIRST),
            Arguments.arguments(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 8), Rank.SECOND),
            Arguments.arguments(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 8, 9), Rank.THIRD),
            Arguments.arguments(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 10, 8, 9), Rank.FORTH)
        );
    }

}