package lotto.domain.rank;

import lotto.domain.lotto.LottoGenerator;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.rank.exceptions.BonusNumberDuplicatedWithLottoTicket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RankCalculatorTests {
    private LottoTicket winTicket;
    private LottoNumber bonusNumber;

    @BeforeEach
    public void setup() {
        winTicket = LottoGenerator.createManualByIntList(
                Arrays.asList(1, 2, 3, 4, 5, 6)
        );
        bonusNumber = LottoNumber.create(10);
    }

    @DisplayName("당첨 로또 티켓을 인자로 전달해서 객체를 생성할 수 있다.")
    @Test
    void creatTest() {
        assertThat(new RankCalculator(winTicket, bonusNumber)).isNotNull();
    }

    @DisplayName("보너스 번호는 당첨 티켓 번호화 중복될 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void calculatorValidationTest(int duplicatedBonusNumber) {
        assertThatThrownBy(() -> new RankCalculator(winTicket, LottoNumber.create(duplicatedBonusNumber)))
                .isInstanceOf(BonusNumberDuplicatedWithLottoTicket.class);
    }

    @DisplayName("입력받은 로또 티켓과 당첨 티켓을 비교해서 몇개의 숫자가 일치하는지 알려줄 수 있다.")
    @ParameterizedTest
    @MethodSource("lottoTicketAndMatchNumber")
    void matchNumberTest(LottoTicket lottoTicket, int matchNumber) {
        RankCalculator rankCalculator = new RankCalculator(winTicket, bonusNumber);
        int ticketResult = rankCalculator.matchNumberCalculate(lottoTicket);
        assertThat(ticketResult).isEqualTo(matchNumber);
    }
    public static Stream<Arguments> lottoTicketAndMatchNumber() {
        return Stream.of(
                Arguments.of(
                        LottoGenerator.createManualByIntList(Arrays.asList(1, 2, 3, 4, 5, 6)),
                        6
                ),
                Arguments.of(
                        LottoGenerator.createManualByIntList(Arrays.asList(2, 3, 4, 5, 6, 7)),
                        5
                ),
                Arguments.of(
                        LottoGenerator.createManualByIntList(Arrays.asList(3, 4, 5, 6, 7, 8)),
                        4
                ),
                Arguments.of(
                        LottoGenerator.createManualByIntList(Arrays.asList(4, 5, 6, 7, 8 ,9)),
                        3
                ),
                Arguments.of(
                        LottoGenerator.createManualByIntList(Arrays.asList(5, 6, 7, 8, 9, 10)),
                        2
                ),
                Arguments.of(
                        LottoGenerator.createManualByIntList(Arrays.asList(6, 7, 8, 9, 10, 11)),
                        1
                ),
                Arguments.of(
                        LottoGenerator.createManualByIntList(Arrays.asList(7, 8, 9, 10, 11, 12)),
                        0
                )
        );
    }

    @DisplayName("제시한 로또 티켓과 1등 티켓 일치하는 갯수와 보너스 번호 일치 여부에 따라 Rank를 받을 수 있다.")
    @ParameterizedTest
    @MethodSource("lottoTicketAndRank")
    void getRankTest(LottoTicket inputLottoTicket, Rank rank) {
        RankCalculator rankCalculator = new RankCalculator(winTicket, bonusNumber);
        Rank calculatedRank = rankCalculator.getRank(inputLottoTicket);
        assertThat(calculatedRank).isEqualTo(rank);
    }
    public static Stream<Arguments> lottoTicketAndRank() {
        return Stream.of(
                Arguments.of(
                        LottoGenerator.createManualByIntList(Arrays.asList(1, 2, 3, 4, 5, 6)),
                        Rank.FIRST
                ),
                Arguments.of(
                        LottoGenerator.createManualByIntList(Arrays.asList(2, 3, 4, 5, 6, 10)),
                        Rank.SECOND
                ),
                Arguments.of(
                        LottoGenerator.createManualByIntList(Arrays.asList(2, 3, 4, 5, 6, 7)),
                        Rank.THIRD
                )
        );
    }
}
