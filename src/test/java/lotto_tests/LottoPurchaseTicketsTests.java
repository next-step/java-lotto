package lotto_tests;

import lotto.model.*;
import lotto.model.wrapper.LottoNumber;
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
                LottoPurchaseTicket.create(
                        LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                        LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6)
                ),
                LottoPurchaseTicket.create(
                        LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                        LottoNumber.of(36), LottoNumber.of(41), LottoNumber.of(45)
                ),
                LottoPurchaseTicket.create(
                        LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                        LottoNumber.of(4), LottoNumber.of(19), LottoNumber.of(20)
                )
        );
    }

    @DisplayName("로또 여러 장 생성 테스트")
    @Test
    public void generateLottoTicketsTest() {
        assertThatCode(() -> new LottoPurchaseTickets(lottoTickets)).doesNotThrowAnyException();
    }

    @DisplayName("로또 결과 테스트")
    @Test
    public void checkAllTest() {
        LottoPurchaseTickets lottoPurchaseTickets = new LottoPurchaseTickets(lottoTickets);
        WinningLottoTicket winningLottoTicket = WinningLottoTicket.create(
                LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6));
        LottoResults expectedResults = LottoResults.create(Arrays.asList(LottoResult.SIX, LottoResult.THREE, LottoResult.FOUR));

        assertThat(lottoPurchaseTickets.checkAll(winningLottoTicket)).isEqualTo(expectedResults);
    }

    @DisplayName("로또 갯수 테스트")
    @Test
    public void sizeTest() {
        LottoPurchaseTickets lottoPurchaseTickets = new LottoPurchaseTickets(lottoTickets);
        assertThat(lottoPurchaseTickets.size()).isEqualTo(lottoTickets.size());
    }
}
