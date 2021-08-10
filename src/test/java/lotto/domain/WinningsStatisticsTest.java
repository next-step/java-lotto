package lotto.domain;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

@SuppressWarnings("NonAsciiCharacters")
class WinningsStatisticsTest {

    @DisplayName("객체생성")
    @Test
    void create() {
        WinningsStatistics winningsStatistics = new WinningsStatistics(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new LottoNumber(35));
        assertThat(winningsStatistics).isInstanceOf(WinningsStatistics.class);
    }

    @DisplayName("보너스번호가 당첨번호에 포함되어 있으면 예외 throw")
    @Test
    void validate_보너스번호가_당첨번호에_포함() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new WinningsStatistics(new Lotto(Arrays.asList(5, 10, 15, 20, 25, 30)), new LottoNumber(10));
        }).withMessageMatching("당첨번호와 보너스번호가 중복되었습니다.");
    }

    @DisplayName("등수정보를 가져온다.")
    @Test
    void makeStatisticsWinnings_등수정보() {
        Lottos lottos = new Lottos(
                Arrays.asList(
                        new Lotto(Arrays.asList(5, 10, 15, 20, 25, 30)),
                        new Lotto(Arrays.asList(5, 10, 15, 20, 25, 35)),
                        new Lotto(Arrays.asList(5, 10, 15, 20, 25, 1)),
                        new Lotto(Arrays.asList(5, 10, 15, 20, 1, 2)),
                        new Lotto(Arrays.asList(5, 10, 15, 1, 2, 3)),
                        new Lotto(Arrays.asList(5, 10, 1, 2, 3, 4)),
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))
                )
        );
        Lotto winningLotto = new Lotto(Arrays.asList(5, 10, 15, 20, 25, 30));
        WinningsStatistics winningsStatistics = new WinningsStatistics(winningLotto, new LottoNumber(35));
        List<Result> winnings = winningsStatistics.makeStatisticsWinnings(lottos);

        assertAll(
                () -> AssertionsForClassTypes.assertThat(winnings.get(0).getHitsCount()).isEqualTo(2),
                () -> AssertionsForClassTypes.assertThat(winnings.get(1).getHitsCount()).isEqualTo(1),
                () -> AssertionsForClassTypes.assertThat(winnings.get(2).getHitsCount()).isEqualTo(1),
                () -> AssertionsForClassTypes.assertThat(winnings.get(3).getHitsCount()).isEqualTo(1),
                () -> AssertionsForClassTypes.assertThat(winnings.get(4).getHitsCount()).isEqualTo(1),
                () -> AssertionsForClassTypes.assertThat(winnings.get(5).getHitsCount()).isEqualTo(1)
        );
    }

    @DisplayName("수익률을 가져온다.")
    @Test
    void calculateEarningsRate_수익률() {
        Lottos lottos = new Lottos(
                Arrays.asList(
                        new Lotto(Arrays.asList(5, 10, 15, 20, 1, 2)),
                        new Lotto(Arrays.asList(5, 10, 15, 1, 2, 3)),
                        new Lotto(Arrays.asList(5, 10, 1, 2, 3, 4)),
                        new Lotto(Arrays.asList(1, 2, 3, 4, 6, 7))
                )
        );
        Lotto winningLotto = new Lotto(Arrays.asList(5, 10, 15, 20, 25, 30));
        WinningsStatistics winningsStatistics = new WinningsStatistics(winningLotto, new LottoNumber(35));
        List<Result> winnings = winningsStatistics.makeStatisticsWinnings(lottos);

        assertThat(winningsStatistics.calculateEarningsRate(winnings, 4)).isEqualTo(13.75);
    }

}
