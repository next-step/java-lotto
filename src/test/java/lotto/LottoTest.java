package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ui.LottoInputUtils;

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
    public void matchLottoNumberRankTest(List<Integer> lottoNums, List<Integer> winningNums, BonusNumber bonusNumber, Rank rank) {

        Lotto lotto = new Lotto(new LottoNumbers(lottoNums));

        Rank sut = lotto.match(new LottoNumbers(winningNums), bonusNumber);

        assertThat(sut).isEqualTo(rank);
    }

    @Test
    @DisplayName("2등, 보너스 번호 당첨")
    public void bonusNumberTest() {
        LottoNumbers lottoNumbers = new LottoNumbers(List.of(1, 2, 3, 4, 5, 8));

        Lotto lotto = new Lotto(lottoNumbers);
        Rank sut = lotto.match(new LottoNumbers(LottoInputUtils.toNumberList("1, 2, 3, 4, 5, 7")), new BonusNumber(8));

        assertThat(sut).isEqualTo(Rank.SECOND);
    }




    static Stream<Arguments> lottoNumberAndWinningNumber() {
        BonusNumber ten = new BonusNumber(10);
        return Stream.of(
            Arguments.arguments(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 6), ten, Rank.FIRST),
            Arguments.arguments(List.of(1, 2, 3, 4, 5, 10), List.of(1, 2, 3, 4, 5, 8), ten, Rank.SECOND),
            Arguments.arguments(List.of(1, 2, 3, 4, 5, 12), List.of(1, 2, 3, 4, 5, 45), ten, Rank.THIRD),
            Arguments.arguments(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 8, 9), ten, Rank.FORTH),
            Arguments.arguments(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 10, 8, 9), ten, Rank.FIFTH)
        );
    }

}