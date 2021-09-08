package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


class LottoTest {
    @Test
    @DisplayName("로또 번호에 대한 유효성 테스트")
    void validLotto() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            getLotto(Arrays.asList(1,2,3));
        });

        assertThatIllegalArgumentException().isThrownBy(() -> {
            getLotto(Arrays.asList(1,2,3,4,5,5));
        });
    }

    @Test
    @DisplayName("당첨 확인 테스트")
    void checkWinning() {
        Lotto winningLotto = getLotto(Arrays.asList(1,2,3,4,5,6));

        assertThat(
                winningLotto.checkWinning(winningLotto)
        ).isEqualTo(LottoRank.FIRST);

        assertThat(
                getLotto(Arrays.asList(10,2,3,4,5,6)).checkWinning(winningLotto)
        ).isEqualTo(LottoRank.THIRD);

        assertThat(
                getLotto(Arrays.asList(10,20,3,4,5,6)).checkWinning(winningLotto)
        ).isEqualTo(LottoRank.FOURTH);

        assertThat(
                getLotto(Arrays.asList(10,20,30,4,5,6)).checkWinning(winningLotto)
        ).isEqualTo(LottoRank.FIFTH);

        assertThat(
                getLotto(Arrays.asList(10,20,30,40,5,6)).checkWinning(winningLotto)
        ).isEqualTo(LottoRank.NONE);

        assertThat(
                getLotto(Arrays.asList(10,20,30,40,45,6)).checkWinning(winningLotto)
        ).isEqualTo(LottoRank.NONE);

        assertThat(
                getLotto(Arrays.asList(10,20,30,40,45,44)).checkWinning(winningLotto)
        ).isEqualTo(LottoRank.NONE);
    }

    private Lotto getLotto(List<Integer> numbers) {
        return new Lotto(numbers.stream().map(LottoNumber::new).collect(Collectors.toList()));
    }
}