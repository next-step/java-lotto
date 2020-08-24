package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {
    private LottoMachine lottoMachine;

    @BeforeEach
    public void init() {
        LottoNumberExtractor lottoNumberExtractor = new LottoNumberRandomExtractor();
        lottoMachine = new LottoMachine(lottoNumberExtractor);
    }

    @Test
    @DisplayName("구입 금액만큼 로또를 발급한다.")
    public void makeLottoTickets() {
        // when
        LottoTickets lottoTickets = lottoMachine.makeLottoTickets(3000);

        // then
        assertThat(lottoTickets.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("수동, 자동으로 로또를 발급한다.")
    public void makeLottoTicketsWithManualTicket() {
        // given
        List<List<Integer>> manualLottoNumbers = new ArrayList<>();
        List<Integer> lottoNumbers1 = Arrays.asList(1, 20, 21, 30, 37, 40);
        List<Integer> lottoNumbers2 = Arrays.asList(11, 15, 23, 29, 38, 43);
        List<Integer> lottoNumbers3 = Arrays.asList(3, 8, 17, 29, 33, 45);
        int price = 10000;

        // when
        LottoTickets lottoTickets = lottoMachine.makeLottoTickets(price, manualLottoNumbers);

        // then
        assertThat(lottoTickets.size()).isEqualTo(price/LottoMachine.LOTTO_PRICE);

    }
}