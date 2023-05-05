package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StaticsTest {

    private Statics staticsFixture;

    @BeforeEach
    public void beforeEach() {
        Ticket winner = Ticket.of((Set.of(1, 2, 4, 8, 16, 32)));
        WinnerTicket winnerTicket = new WinnerTicket(winner, (LottoNumber.of(33)));

        Ticket first = Ticket.of(Set.of(1, 2, 4, 8, 16, 32));
        Ticket secondA = Ticket.of(Set.of(1, 2, 4, 8, 16, 33));
        Ticket secondB = Ticket.of(Set.of(1, 2, 4, 8, 32, 33));

        Ticket thirdA = Ticket.of(Set.of(1, 2, 4, 8, 16, 40));
        Ticket thirdB = Ticket.of(Set.of(1, 2, 4, 8, 16, 41));
        Ticket thirdC = Ticket.of(Set.of(1, 2, 4, 8, 16, 42));

        Ticket fourthA = Ticket.of(Set.of(1, 2, 33, 4, 35, 8));
        Ticket fourthB = Ticket.of(Set.of(1, 2, 33, 4, 35, 8));
        Ticket fourthC = Ticket.of(Set.of(1, 2, 33, 4, 35, 8));
        Ticket fourthD = Ticket.of(Set.of(1, 2, 33, 4, 35, 8));

        Ticket fifthA = Ticket.of(Set.of(1, 2, 4, 15, 26, 37));
        Ticket fifthB = Ticket.of(Set.of(1, 2, 4, 25, 26, 17));
        Ticket fifthC = Ticket.of(Set.of(1, 2, 4, 35, 36, 37));
        Ticket fifthD = Ticket.of(Set.of(1, 2, 4, 25, 36, 27));
        Ticket fifthE = Ticket.of(Set.of(1, 2, 4, 35, 26, 17));

        Tickets purchaseTicketsFixture = new Tickets(List.of(
                first, secondA, secondB,
                thirdA, thirdB, thirdC,
                fourthA, fourthB, fourthC, fourthD,
                fifthA, fifthB, fifthC, fifthD, fifthE
        ));
        staticsFixture = new Statics(purchaseTicketsFixture, winnerTicket);
    }

    @DisplayName("1등 담첨통계가 계산된다(6개 번호 일치)")
    @Test
    public void first() {
        //given
        int answer = 1;
        //when
        int countFirst = staticsFixture.countPrize(Prize.FIRST);
        //then
        assertEquals(answer, countFirst);
    }

    @DisplayName("2등 당첨통계가 계산된다(5개 + 보너스 번호 일치)")
    @Test
    public void second() {
        //given
        int expect = 2;
        //when
        int actual = staticsFixture.countPrize(Prize.SECOND);
        //then
        assertEquals(expect, actual);
    }

    @DisplayName("3등 당첨통계가 계산된다(5개 번호 일치)")
    @Test
    public void third() {
        //given
        int answer = 3;
        //when
        int countFirst = staticsFixture.countPrize(Prize.THIRD);
        //then
        assertEquals(answer, countFirst);
    }

    @DisplayName("4등 당첨통계가 계산된다(4개 번호 일치)")
    @Test
    public void forth() {
        //given
        int answer = 4;
        //when
        int countFirst = staticsFixture.countPrize(Prize.FOURTH);
        //then
        assertEquals(answer, countFirst);
    }

    @DisplayName("5등 당첨통계가 계산된다(3개 번호 일치)")
    @Test
    public void fifth() {
        //given
        int answer = 5;
        //when
        int countFirst = staticsFixture.countPrize(Prize.FIFTH);
        //then
        assertEquals(answer, countFirst);
    }

    @DisplayName("당첨금액을 계산한다")
    @Test
    public void income() {
        //given
        int expected = 2_064_725_000;
        //when
        int actual = staticsFixture.getIncome();
        //then
        assertAll("당첨금액 = Prize.FIRST.prizeCalculate(1) + Prize.SECOND.prizeCalculate(2) + Prize.THIRD.prizeCalculate(3) + Prize.FOURTH.prizeCalculate(4) + Prize.FIFTH.prizeCalculate(5)",
                () -> assertEquals(2_000_000_000, Prize.FIRST.calculatePrize(staticsFixture.countPrize(Prize.FIRST))),
                () -> assertEquals(30_000_000 * 2, Prize.SECOND.calculatePrize(staticsFixture.countPrize(Prize.SECOND))),
                () -> assertEquals(1_500_000 * 3, Prize.THIRD.calculatePrize(staticsFixture.countPrize(Prize.THIRD))),
                () -> assertEquals(50_000 * 4, Prize.FOURTH.calculatePrize(staticsFixture.countPrize(Prize.FOURTH))),
                () -> assertEquals(5_000 * 5, Prize.FIFTH.calculatePrize(staticsFixture.countPrize(Prize.FIFTH))),
                () -> assertEquals(expected, actual)
        );
    }

    @DisplayName("투자금 대비 당첨금액의 비율을 사이의 소수점 둘째자리까지 표시한다")
    @Test
    public void returnRatio() {
        //given
        int answerX1000 = 137648333;
        //when
        int ratioX1000 = (int) (staticsFixture.profitRatio() * 1000);
        //then
        assertThat(ratioX1000).as("double type 은 equal 평가가 곤란해서 1000을 곱한다음 int 형식으로 캐스팅하여 검증했습니다").isEqualTo(answerX1000);
        assertThat(ratioX1000).as("투자금 13게임[13000₩], 수익금[2004725000₩], 투자대비 수익비율 [154209.615385]").isEqualTo(answerX1000);
    }
}