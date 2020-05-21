package lotto.ui;

import lotto.domain.lotto.LottoGenerator;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.LottoTickets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class BuyOutputViewTests {
    private LottoTickets fakeLottoTickets;

    @BeforeEach
    public void setup() {
        LottoTicket fakeLottoTicket1 = LottoGenerator.createManualByIntList(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoTicket fakeLottoTicket2 = LottoGenerator.createManualByIntList(Arrays.asList(7, 8, 9, 10, 11, 12));
        fakeLottoTickets = LottoTickets.create(Arrays.asList(fakeLottoTicket1, fakeLottoTicket2));
    }

    @DisplayName("구입한 LottoTickets 인자를 주입받아서 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        BuyOutputView buyOutputView = new BuyOutputView(fakeLottoTickets);
        assertThat(buyOutputView).isNotNull();
    }

    @DisplayName("갖고 있는 LottoTickets의 상태를 String으로 바꿀 수 있다.")
    @Test
    void convertToStringTest() {
        BuyOutputView buyOutputView = new BuyOutputView(fakeLottoTickets);
        assertThat(buyOutputView.convertToString()).isEqualTo("[1, 2, 3, 4, 5, 6]\n[7, 8, 9, 10, 11, 12]");
    }
}
