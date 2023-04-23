package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WinnersTest {

    private Winners winnersFixture;


    @BeforeEach
    public void beforeEach() {
        Ticket winner = new Ticket(Set.of(1, 2, 4, 8, 16, 32));

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

        List<Ticket> purchaseTicketsFixture = List.of(
                first,
                thirdA, thirdB, thirdC,
                fourthA, fourthB, fourthC, fourthD,
                fifthA, fifthB, fifthC, fifthD, fifthE
        );
        winnersFixture = new Winners(purchaseTicketsFixture, winner);
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
        int answer = 2_004_725_000;
        //when
        int income = winnersFixture.getIncome();
        //then
        assertThat(income).isEqualTo(answer).as("당첨금액 계산식 = Prize.FIRST.prizeCalculate(1) + Prize.THIRD.prizeCalculate(3) + Prize.FOURTH.prizeCalculate(4) + Prize.FIFTH.prizeCalculate(5)");
    }

    @DisplayName("투자금 대비 당첨금액의 비율을 사이의 소수점 둘째자리까지 표시한다")
    @Test
    public void returnRatio() {
        //given
        int answerX1000 = 154209615;
        //when
        int ratioX1000 = (int) (winnersFixture.getProfitRatio() * 1000);
        //then
        assertThat(ratioX1000).isEqualTo(answerX1000).as("double 형식은 값비교가 힘들어서 1000을 곱한다음 int 형식으로 캐스팅하여 검증했습니다");
        assertThat(ratioX1000).isEqualTo(answerX1000).as("투자금 13게임[13000₩], 수익금[2004725000₩], 투자대비 수익비율 [154209.615385]");
    }
}