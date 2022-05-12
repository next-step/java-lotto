package study.step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("당첨 결과")
class LottoRankTest {

    private LottoWinners winners;

    @BeforeEach
    public void setUp() {
        winners = LottoMachine.createWinners("1,2,3,4,5,6", 45);
    }

    @Test
    @DisplayName("로또 꽝 생성 확인")
    void 로또_꽝_생성_확인() {
        String inputLottoThree = "1,2,42,43,44,45";
        LottoTicket ticket = LottoMachine.createLottoTicket(inputLottoThree);

        assertThat(LottoRank.valueOf(ticket, winners)).isEqualTo(LottoRank.MISS);
    }

    @Test
    @DisplayName("로또 당첨 5등 생성 확인")
    void 로또당첨_5등_생성확인() {
        String inputLottoThree = "1,2,3,43,44,45";
        LottoTicket ticket = LottoMachine.createLottoTicket(inputLottoThree);

        assertThat(LottoRank.valueOf(ticket, winners)).isEqualTo(LottoRank.FIFTH);
    }

    @Test
    @DisplayName("로또 당첨 4등 생성 확인")
    void 로또당첨_4등_생성확인() {
        String inputLottoFour = "1,2,3,4,44,45";
        LottoTicket ticket = LottoMachine.createLottoTicket(inputLottoFour);

        assertThat(LottoRank.valueOf(ticket, winners)).isEqualTo(LottoRank.FOURTH);
    }

    @Test
    @DisplayName("로또 당첨 3등 생성 확인")
    void 로또당첨_3등_생성확인() {
        String inputLottoFive = "1,2,3,4,5,44";
        LottoTicket ticket = LottoMachine.createLottoTicket(inputLottoFive);

        assertThat(LottoRank.valueOf(ticket, winners)).isEqualTo(LottoRank.THIRD);
    }

    @Test
    @DisplayName("로또 당첨 2등(보너스볼) 생성 확인")
    void 로또당첨_2등_보너스볼_생성확인() {
        String inputLottoFive = "1,2,3,4,5,45";
        LottoTicket ticket = LottoMachine.createLottoTicket(inputLottoFive);

        assertThat(LottoRank.valueOf(ticket, winners)).isEqualTo(LottoRank.SECOND);
    }

    @Test
    @DisplayName("로또 당첨 1등 생성 확인")
    void 로또당첨_1등_생성확인() {
        String inputLottoSix = "1,2,3,4,5,6";
        LottoTicket ticket = LottoMachine.createLottoTicket(inputLottoSix);

        assertThat(LottoRank.valueOf(ticket, winners)).isEqualTo(LottoRank.FIRST);
    }
}