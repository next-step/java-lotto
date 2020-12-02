package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


class WinningNumbersTest {

    private static final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
    private static final WinningNumbers winningNumbers = new WinningNumbers("1, 2, 3, 4, 5, 6", 7);

    @ParameterizedTest
    @DisplayName("로또번호 별 당첨 번호, 보너스 번호와 일치하는 당첨순위(Rank)를 반환한다.")
    @CsvSource(value = {
            "1, 7, 8, 9, 10, 11:1:false",
            "1, 2, 8, 9, 10, 11:2:false",
            "1, 2, 3, 9, 10, 11:3:false",
            "1, 2, 3, 4, 5, 11:5:false",
            "1, 2, 3, 4, 5, 7:5:true",
            "1, 2, 3, 4, 5, 6:6:false"
    }, delimiter = ':')
    void should_return_rank(String inputNumbers, int matchingCount, boolean matchBonus) {
        //Given
        LottoNumbers lotto = lottoNumberGenerator.create(inputNumbers);

        //When
        Rank expectedRank = Rank.value(matchingCount, matchBonus);

        //Then
        assertThat(winningNumbers.getRank(lotto)).isEqualTo(expectedRank);

    }

}
