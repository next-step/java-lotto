package lottoauto;

import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;

public class LottoTicketTest {

    private LottoTicket lottoTicket;

    @BeforeEach
    void setUp() {
        lottoTicket = new LottoTicket(new LottoNumbers(Arrays.asList(1,2,3,4,5,6)));
    }




}
