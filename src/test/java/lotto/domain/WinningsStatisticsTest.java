package lotto.domain;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

@SuppressWarnings("NonAsciiCharacters")
class WinningsStatisticsTest {

    @DisplayName("객체생성")
    @Test
    void create() {
        WinningsStatistics winningsStatistics = new WinningsStatistics(Lotto.valueOf("5,10,15,20,25,30"), new LottoNumber(35));
        assertThat(winningsStatistics).isInstanceOf(WinningsStatistics.class);
    }

    @DisplayName("보너스번호가 당첨번호에 포함되어 있으면 예외 throw")
    @Test
    void validate_보너스번호가_당첨번호에_포함() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new WinningsStatistics(Lotto.valueOf("5,10,15,20,25,30"), new LottoNumber(10));
        }).withMessageMatching("당첨번호와 보너스번호가 중복되었습니다.");
    }

    @DisplayName("등수정보를 가져온다.")
    @Test
    void makeStatisticsWinnings_등수정보() {
        Lottos lottos = new Lottos(
                Arrays.asList(
                        Lotto.valueOf("5,10,15,20,25,30"),
                        Lotto.valueOf("5,10,15,20,25,35"),
                        Lotto.valueOf("5,10,15,20,25,1"),
                        Lotto.valueOf("5,10,15,20,1,2"),
                        Lotto.valueOf("5,10,15,1,2,3"),
                        Lotto.valueOf("5,10,1,2,3,4"),
                        Lotto.valueOf("1,2,3,4,6,7")
                )
        );
        Lotto winningLotto = Lotto.valueOf("5,10,15,20,25,30");
        WinningsStatistics winningsStatistics = new WinningsStatistics(winningLotto, new LottoNumber(35));
        Map<Rank, MatchingCount> winnings = winningsStatistics.makeStatisticsWinnings(lottos);

        assertAll(
                () -> AssertionsForClassTypes.assertThat(winnings.get(Rank.FIRST)).isEqualTo(new MatchingCount(1)),
                () -> AssertionsForClassTypes.assertThat(winnings.get(Rank.SECOND)).isEqualTo(new MatchingCount(1)),
                () -> AssertionsForClassTypes.assertThat(winnings.get(Rank.THIRD)).isEqualTo(new MatchingCount(1)),
                () -> AssertionsForClassTypes.assertThat(winnings.get(Rank.FOURTH)).isEqualTo(new MatchingCount(1)),
                () -> AssertionsForClassTypes.assertThat(winnings.get(Rank.MISS)).isEqualTo(new MatchingCount(2))
        );
    }

    @DisplayName("수익률을 가져온다.")
    @Test
    void calculateEarningsRate_수익률() {
        Lottos lottos = new Lottos(
                Arrays.asList(
                        Lotto.valueOf("5,10,15,20,1,2"),
                        Lotto.valueOf("5,10,15,1,2,3"),
                        Lotto.valueOf("5,10,1,2,3,4"),
                        Lotto.valueOf("1,2,3,4,6,7")
                )
        );
        Lotto winningLotto = Lotto.valueOf("5,10,15,20,25,30");
        WinningsStatistics winningsStatistics = new WinningsStatistics(winningLotto, new LottoNumber(35));
        Map<Rank, MatchingCount> winnings = winningsStatistics.makeStatisticsWinnings(lottos);

        assertThat(winningsStatistics.calculateEarningsRate(winnings, 4)).isEqualTo(13.75);
    }

}
