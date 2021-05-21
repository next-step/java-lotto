package lotto.domain;

import lotto.domain.rank.LottoRank;
import lotto.domain.rank.LottoRanks;
import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.LottoTickets;
import lotto.util.LottoStringFixtureUtil;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static lotto.util.LottoStringFixtureUtil.convertStringToLottoNumberList;
import static lotto.util.LottoStringFixtureUtil.lottoNumbersSortedByRank;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LottoWonTest {
    private LottoWon lottoWon;

    @BeforeEach
    public void setUp() {
        lottoWon = new LottoWon(convertStringToLottoNumberList("1,2,3,4,5,6"), LottoNumber.of(7));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "1,2,3,5,8,9", "10,11,12,13,14,15"})
    @DisplayName("로또승리는_6개의_로또번호를_가진다")
    public void 로또승리는_6개의_로또번호를_가진다(String fixtureLottoNumber) {
        assertDoesNotThrow(() -> new LottoWon(convertStringToLottoNumberList(fixtureLottoNumber), LottoNumber.of(7)));
    }

    @Test
    @DisplayName("로또번호 안에 보너스번호가 있으면 IllegalArgumentException이 발생한다")
    public void 로또번호_안에_보너스번호가_있으면_IllegalArgumentException이_발생한다() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoWon(convertStringToLottoNumberList("1,2,3,4,5,6"), LottoNumber.of(6)));
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "1#FIRST",
                    "2#SECOND",
                    "3#THIRD",
                    "4#FOURTH",
                    "5#FIFTH",
                    "6#MISS",
                    "7#MISS",
                    "8#MISS"
            },
            delimiter = '#'
    )
    @DisplayName("로또를 입력받아 등수를 알 수 있다.")
    public void 로또를_입력받아_등수를_알_수_있다(int index, LottoRank exceptLottoRank) {
        LottoTicket lottoTicket = new LottoTicket(convertStringToLottoNumberList(lottoNumbersSortedByRank()[index]));

        assertThat(lottoWon.match(lottoTicket))
                .isEqualTo(exceptLottoRank);
    }

    @Test
    @DisplayName("로또 티켓들을 입력받아 등수를 알 수 있다")
    public void 로또_티켓들을_입력받아_등수를_알_수_있다() {
        LottoTickets lottoTickets = new LottoTickets(
                Arrays.asList(
                        new LottoTicket(convertStringToLottoNumberList("1,2,3,4,5,6")),
                        new LottoTicket(convertStringToLottoNumberList("11,2,3,4,5,6")),
                        new LottoTicket(convertStringToLottoNumberList("11,12,3,4,5,6")),
                        new LottoTicket(convertStringToLottoNumberList("11,12,13,4,5,6")),
                        new LottoTicket(convertStringToLottoNumberList("11,12,13,14,5,6")),
                        new LottoTicket(convertStringToLottoNumberList("11,12,13,14,15,6")),
                        new LottoTicket(convertStringToLottoNumberList("11,12,13,14,15,16"))
                )
        );

        LottoRanks match = lottoWon.match(lottoTickets);

        assertThat(match.countOf(LottoRank.FIRST))
                .isEqualTo(1);
        assertThat(match.countOf(LottoRank.THIRD))
                .isEqualTo(1);
        assertThat(match.countOf(LottoRank.FOURTH))
                .isEqualTo(1);
        assertThat(match.countOf(LottoRank.FIFTH))
                .isEqualTo(1);
        assertThat(match.countOf(LottoRank.MISS))
                .isEqualTo(3);
    }
}