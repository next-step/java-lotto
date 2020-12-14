package lotto.domain.numbers;

import lotto.domain.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketTest {
    private LottoTicket lottoTicket;

    @BeforeEach
    void setUp() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        Arrays.asList(1, 8, 10, 14, 21, 30)
                .forEach(num -> lottoNumbers.add(new LottoNumber(num)));
        lottoTicket = new LottoTicket(lottoNumbers);
    }

    @DisplayName("LottoTicket 생성 시 로또 숫자가 6개 아닌 경우, Exception 발생")
    @Test
    void validate() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(5));

        assertThatThrownBy(() -> new LottoTicket(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 숫자가 부족합니다.");
    }

    @DisplayName("당첨 번호와 보너스 볼 둘다 비교하여 맞춘 갯수에 따라 Rank를 리턴한다.")
    @ParameterizedTest
    @MethodSource("provideWinningNumbers")
    void matchWinningLottoNumbers(String numbers, LottoNumber bonusNumber, Rank expectedRank) {
        Rank result = lottoTicket.matchWinningLottoNumbers(new WinningLottoNumbers(numbers, bonusNumber));
        assertThat(result).isEqualTo(expectedRank);
    }

    private static Stream<Arguments> provideWinningNumbers() {
        return Stream.of(
                Arguments.of("1, 8, 10, 15, 22, 35", new LottoNumber(30), Rank.FIFTH),
                Arguments.of("1, 8, 10, 14, 21, 40", new LottoNumber(30), Rank.SECOND),
                Arguments.of("1, 8, 10, 14, 21, 40", new LottoNumber(22), Rank.THIRD)
        );
    }
}
