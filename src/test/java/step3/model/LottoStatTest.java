package step3.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStatTest {

    private LottoStat stat;

    @BeforeEach
    @DisplayName("테스트 시작 전 테스트 데이터 미리 입력")
    void setUp() {
        List<LottoTicket> ticketList = new ArrayList<>();
        final String winningNumber = "3,5,6,7,9,11";
        final int bonusBall = 8;
        ticketList.add(new LottoTicket("[3,5,6,15,22,24]")); // 5등
        ticketList.add(new LottoTicket("[3,5,6,15,21,24]")); // 5등
        ticketList.add(new LottoTicket("[3,5,6,7,22,24]")); // 4등
        ticketList.add(new LottoTicket("[3,5,6,7,22,26]")); // 4등
        ticketList.add(new LottoTicket("[3,5,6,7,22,31]")); // 4등
        ticketList.add(new LottoTicket("[3,5,6,7,9,24]")); // 3등
        ticketList.add(new LottoTicket("[3,5,6,7,8,9]")); // 2등
        ticketList.add(new LottoTicket("[3,5,6,7,8,11]")); // 2등

        ticketList.add(new LottoTicket("[3,5,6,7,9,11]")); // 1등


        stat = new LottoStat();
        stat.enterLottoTicketScore(ticketList, winningNumber.split(","), bonusBall);
    }

    @ParameterizedTest
    @CsvSource(value = {"FIFTH,2", "FOURTH,3", "THIRD,1", "SECOND,2", "FIRST,1"})
    @DisplayName("테스트 시작전에 입력된 데이터들을 가지고 통계를 정상적으로 생성하는지 확인")
    void check_Ticket_with_Input_Score(Rank r1, int expected) {
        assertThat(stat.getNumberOfGrade(r1)).isEqualTo(expected);
    }
}
