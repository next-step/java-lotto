package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static lotto.domain.LottoNumber.from;
import static lotto.domain.Rank.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("WinningLottoNumber 테스트")
class WinningLottoNumberTest {

    private List<LottoGame> mockLottoGameList = Arrays.asList(
            new LottoGame(new HashSet(Arrays.asList(from(1), from(2), from(3), from(4), from(5), from(6)))),
            new LottoGame(new HashSet(Arrays.asList(from(1), from(2), from(3), from(4), from(5), from(7)))),
            new LottoGame(new HashSet(Arrays.asList(from(1), from(2), from(3), from(4), from(8), from(9)))),
            new LottoGame(new HashSet(Arrays.asList(from(1), from(2), from(3), from(10), from(11), from(12)))),
            new LottoGame(new HashSet(Arrays.asList(from(1), from(2), from(3), from(13), from(14), from(15))))
    );

    @DisplayName("decidePrize_정상")
    @Test
    void decidePrize_정상() {
        // Given
        WinningLottoNumber winningLottoNumber = new WinningLottoNumber("1,2,3,4,5,6");
        LottoGames lottoGames = new LottoGames(mockLottoGameList);
        final int EXPECTED_FIRST_COUNT = 1;
        final int EXPECTED_SECOND_COUNT = 1;
        final int EXPECTED_THIRD_COUNT = 1;
        final int EXPECTED_FOURTH_COUNT = 2;

        // When
        LottoResult lottoResult = winningLottoNumber.decidePrize(lottoGames);

        // Then
        assertThat(lottoResult.get(FIRST)).isEqualTo(EXPECTED_FIRST_COUNT);
        assertThat(lottoResult.get(SECOND)).isEqualTo(EXPECTED_SECOND_COUNT);
        assertThat(lottoResult.get(THIRD)).isEqualTo(EXPECTED_THIRD_COUNT);
        assertThat(lottoResult.get(FOURTH)).isEqualTo(EXPECTED_FOURTH_COUNT);
    }
}