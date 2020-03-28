package LottoTests;

import lotto.model.LottoPurchaseTicket;
import lotto.model.LottoPurchaseTickets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;

@DisplayName("로또 여러 장 테스트")
public class LottoPurchaseTicketsTests {

    private List<LottoPurchaseTicket> lottoTickets = new ArrayList<>();

    @BeforeEach
    void init() {
        lottoTickets = Arrays.asList(
                LottoPurchaseTicket.newInstance(Arrays.asList(1, 2, 3, 4, 5, 6)),
                LottoPurchaseTicket.newInstance(Arrays.asList(1, 2, 3, 36, 41, 45)),
                LottoPurchaseTicket.newInstance(Arrays.asList(1, 2, 3, 4, 19, 20))
        );
    }

    @DisplayName("로또 여러 장 생성 테스트")
    @Test
    public void generateLottoTest() {
        assertThatCode(() -> LottoPurchaseTickets.create(lottoTickets)).doesNotThrowAnyException();
    }

}
