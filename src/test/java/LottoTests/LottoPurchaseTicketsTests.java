package LottoTests;

import lotto.utils.LottoNumberAdaptor;
import lotto.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

@DisplayName("로또 여러 장 테스트")
public class LottoPurchaseTicketsTests {

    private List<LottoPurchaseTicket> lottoTickets = new ArrayList<>();

    @BeforeEach
    void init() {
        lottoTickets = Arrays.asList(
                LottoPurchaseTicket.newInstance(LottoNumberAdaptor.convert(Arrays.asList(1, 2, 3, 4, 5, 6))),
                LottoPurchaseTicket.newInstance(LottoNumberAdaptor.convert(Arrays.asList(1, 2, 3, 36, 41, 45))),
                LottoPurchaseTicket.newInstance(LottoNumberAdaptor.convert(Arrays.asList(1, 2, 3, 4, 19, 20)))
        );
    }

    @DisplayName("로또 여러 장 생성 테스트")
    @Test
    public void generateLottoTicketsTest() {
        assertThatCode(() -> LottoPurchaseTickets.create(lottoTickets)).doesNotThrowAnyException();
    }

    @DisplayName("로또 결과 테스트")
    @Test
    public void checkAllTest() {
        LottoPurchaseTickets lottoPurchaseTickets = LottoPurchaseTickets.create(lottoTickets);
        WinningLottoTicket winningLottoTicket = WinningLottoTicket.newInstance(LottoNumberAdaptor.convert(Arrays.asList(1, 2, 3, 4, 5, 6)));
        LottoResults expectedResults = LottoResults.create(Arrays.asList(LottoResult.SIX, LottoResult.THREE, LottoResult.FOUR));

        assertThat(lottoPurchaseTickets.checkAll(winningLottoTicket)).isEqualTo(expectedResults);
    }
}
