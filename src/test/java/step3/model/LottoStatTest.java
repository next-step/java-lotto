package step3.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.List;

public class LottoStatTest {

    private LottoStat stat;
    private LottoNumberGenerator generator;

    @BeforeEach
    @DisplayName("테스트 시작 전 테스트 데이터 미리 입력")
    void setUp() {
        List<LottoTicket> ticketList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ticketList.add(generator.generatedLottoTicketByRandom());
        }
        stat = new LottoStat();
        stat.enterLottoTicket(ticketList);
    }


}
