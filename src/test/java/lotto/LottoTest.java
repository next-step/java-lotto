package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


class LottoTest {

    @Test
    @DisplayName("당첨 확인 테스트")
    void checkWinning() {
        LottoNumbers winningLottoNumbers = new LottoNumbers(
                Stream.of(1,2,3,4,5,6).map(LottoNumber::new).collect(Collectors.toList())
        );
        Lotto winningLotto = new Lotto(winningLottoNumbers);

        assertThat(
                winningLotto.checkWinning(winningLottoNumbers)
        ).isEqualTo(LottoRank.FIRST);

        assertThat(
                getLotto(Arrays.asList(10,2,3,4,5,6)).checkWinning(winningLottoNumbers)
        ).isEqualTo(LottoRank.THIRD);

        assertThat(
                getLotto(Arrays.asList(10,20,3,4,5,6)).checkWinning(winningLottoNumbers)
        ).isEqualTo(LottoRank.FOURTH);

        assertThat(
                getLotto(Arrays.asList(10,20,30,4,5,6)).checkWinning(winningLottoNumbers)
        ).isEqualTo(LottoRank.FIFTH);

        assertThat(
                getLotto(Arrays.asList(10,20,30,40,5,6)).checkWinning(winningLottoNumbers)
        ).isEqualTo(LottoRank.NONE);

        assertThat(
                getLotto(Arrays.asList(10,20,30,40,45,6)).checkWinning(winningLottoNumbers)
        ).isEqualTo(LottoRank.NONE);

        assertThat(
                getLotto(Arrays.asList(10,20,30,40,45,44)).checkWinning(winningLottoNumbers)
        ).isEqualTo(LottoRank.NONE);
    }

    private Lotto getLotto(List<Integer> numbers) {
        return new Lotto(new LottoNumbers(
                numbers.stream().map(LottoNumber::new).collect(Collectors.toList())
        ));
    }
}