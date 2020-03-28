package LottoTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatCode;

@DisplayName("로또 여러 장 테스트")
public class LottoPurchaseTicketsTests {

    private List<LottoTicket> lottoTickets = new ArrayList<>();

    @BeforeEach
    void init() {
        lottoTickets = Arrays.asList(
                LottoTicket.newInstance(1, 2, 3, 4, 5, 6),
                LottoTicket.newInstance(1, 2, 3, 36, 41, 45),
                LottoTicket.newInstance(1, 2, 3, 4, 19, 20)
        );
    }

    @DisplayName("로또 여러 장 생성 테스트")
    @Test
    public void generateLottoTest() {
        assertThatCode(() -> LottoTickets.create(lottoTickets)).doesNotThrowAnyException();
    }

}
