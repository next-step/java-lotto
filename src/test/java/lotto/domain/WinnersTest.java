package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WinnersTest {

    private Winners winnersFixture;
    private Ticket winTicketFixture;
    private List<Ticket> purchaseTicketsFixture;

    @BeforeEach
    public void beforeEach() {
        winTicketFixture = new Ticket(Set.of(1, 2, 4, 8, 16, 32));

        Ticket first = new Ticket(Set.of(1, 2, 4, 8, 16, 32));

        Ticket thirdA = new Ticket(Set.of(1, 2, 4, 8, 16,40));
        Ticket thirdB = new Ticket(Set.of(1, 2, 4, 8, 16,41));
        Ticket thirdC = new Ticket(Set.of(1, 2, 4, 8, 16,42));

        Ticket fourthA = new Ticket(Set.of(1, 2, 33, 4, 35, 8));
        Ticket fourthB = new Ticket(Set.of(1, 2, 33, 4, 35, 8));
        Ticket fourthC = new Ticket(Set.of(1, 2, 33, 4, 35, 8));
        Ticket fourthD = new Ticket(Set.of(1, 2, 33, 4, 35, 8));

        Ticket fifthA = new Ticket(Set.of(1, 2, 4, 15, 26, 37));
        Ticket fifthB = new Ticket(Set.of(1, 2, 4, 25, 26, 17));
        Ticket fifthC = new Ticket(Set.of(1, 2, 4, 35, 36, 37));
        Ticket fifthD = new Ticket(Set.of(1, 2, 4, 25, 36, 27));
        Ticket fifthE = new Ticket(Set.of(1, 2, 4, 35, 26, 17));

        purchaseTicketsFixture = List.of(
                first,
                thirdA, thirdB, thirdC,
                fourthA, fourthB, fourthC, fourthD,
                fifthA, fifthB, fifthC, fifthD, fifthE
        );
        winnersFixture = new Winners(purchaseTicketsFixture, winTicketFixture);
    }

    @DisplayName("1등 담첨통계가 계산된다(6개 번호 일치)")
    @Test
    public void first() {
        //given
        int answer = 1;
        //when
        int countFirst = winnersFixture.getCountFirst();
        //then
        assertEquals(answer, countFirst);
    }

    @DisplayName("3등 당첨통계가 계산된다(5개 번호 일치)")
    @Test
    public void third() {
        //given
        int answer = 3;
        //when
        int countFirst = winnersFixture.getCountThird();
        //then
        assertEquals(answer, countFirst);
    }
    @DisplayName("4등 당첨통계가 계산된다(4개 번호 일치)")
    @Test
    public void forth() {
        //given
        int answer = 4;
        //when
        int countFirst = winnersFixture.getCountFourth();
        //then
        assertEquals(answer, countFirst);
    }
    @DisplayName("5등 당첨통계가 계산된다(3개 번호 일치)")
    @Test
    public void fifth() {
        //given
        int answer = 5;
        //when
        int countFirst = winnersFixture.getCountFifth();
        //then
        assertEquals(answer, countFirst);
    }
    @DisplayName("당첨금액을 계산한다")
    @Test
    public void income() {
        //given
        int answer = Prize.FIRST.prizeCalculate(1) +
                Prize.THIRD.prizeCalculate(3) +
                Prize.FOURTH.prizeCalculate(4) +
                Prize.FIFTH.prizeCalculate(5);
        //when
        int income = winnersFixture.getIncome();
        //then
        assertEquals(answer, income);
    }

    @DisplayName("투자금 대비 당첨금액의 비율을 사이의 소수점 둘째자리까지 표시한다")
    @Test
    public void returnRatio() {
        //given
        double answer = 2.00;//계산필요 아직모름
        //when
        double ratio = winnersFixture.returnRatio();
        //then
        assertEquals(answer, ratio);
    }
}