package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoJudgeTest {

    private GoldenTicket goldenTicket;

    @BeforeEach
    void setUp() {
        LottoTicket winningTicket = new LottoTicket(createPickedWinningNumbers());
        LottoNumber bonusNumber = LottoNumber.of(45);
        goldenTicket = new GoldenTicket(winningTicket, bonusNumber);
    }

    @DisplayName("1등을 확인하는 랭크를 확인하는 테스트")
    @Test
    void getFirstRankTest() {
        // given
        LottoTicket lottoTicket = new LottoTicket(createPickedWinningNumbers());
        LottoJudge lottoJudge = new LottoJudge(goldenTicket, lottoTicket);

        // when
        Rank rank = lottoJudge.determine();

        // then
        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @DisplayName("2등을 확인하는 랭크를 확인하는 테스트")
    @Test
    void getSecondRankTest() {
        // given
        LottoTicket lottoTicket = new LottoTicket(createPickedSecondNumbers());
        LottoJudge lottoJudge = new LottoJudge(goldenTicket, lottoTicket);

        // when
        Rank rank = lottoJudge.determine();

        // then
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @DisplayName("3등을 확인하는 랭크를 확인하는 테스트")
    @Test
    void getThirdRankTest() {
        // given
        LottoTicket lottoTicket = new LottoTicket(createPickedThirdNumbers());
        LottoJudge lottoJudge = new LottoJudge(goldenTicket, lottoTicket);

        // when
        Rank rank = lottoJudge.determine();

        // then
        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    private List<LottoNumber> createPickedWinningNumbers() {
        return Arrays.asList(
                LottoNumber.of(8),
                LottoNumber.of(21),
                LottoNumber.of(23),
                LottoNumber.of(41),
                LottoNumber.of(42),
                LottoNumber.of(43)
        );
    }

    private List<LottoNumber> createPickedSecondNumbers() {
        return Arrays.asList(
                LottoNumber.of(8),
                LottoNumber.of(21),
                LottoNumber.of(23),
                LottoNumber.of(41),
                LottoNumber.of(42),
                LottoNumber.of(45)
        );
    }

    private List<LottoNumber> createPickedThirdNumbers() {
        return Arrays.asList(
                LottoNumber.of(8),
                LottoNumber.of(21),
                LottoNumber.of(23),
                LottoNumber.of(41),
                LottoNumber.of(42),
                LottoNumber.of(44)
        );
    }
}