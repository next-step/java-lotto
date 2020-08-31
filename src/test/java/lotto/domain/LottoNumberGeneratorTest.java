package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberGeneratorTest {

    private List<String> mockManualLottoTickets;

    @BeforeEach
    void setUp() {
        initManualLottoTicket();
    }

    private void initManualLottoTicket() {
        mockManualLottoTickets = new ArrayList<>();
        mockManualLottoTickets.add("1,2,3,4,5,6");
        mockManualLottoTickets.add("1,2,3,4,5,7");
        mockManualLottoTickets.add("1,2,3,4,5,8");
    }

    @Test
    @DisplayName("자동 로또 번호가 총 6개인지 확인")
    void createAutoLottoTicket() {
        LottoTicket lottoNumbers = LottoNumberGenerator.generateAutoLottoTicket();
        assertThat(lottoNumbers.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("n개의 로또 복권 생성")
    void createAutoLottoTickets() {
        List<LottoTicket> lottoTickets = LottoNumberGenerator.generateAutoLottoTickets(3);
        assertThat(lottoTickets.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("당첨 번호 생성")
    void createWinningNumbers() {
        LottoTicket winningNumbers = LottoNumberGenerator.generateWinningNumber("1,2,3,4,5,6");
        assertThat(winningNumbers.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("수동 로또 번호 생성")
    void createManualLottoTicket() {
        LottoTicket lottoTicket = LottoNumberGenerator.generateManualLottoTicket("1,2,3,4,5,6");
        assertThat(lottoTicket.getLottoTicket()).isEqualTo(Arrays.asList(1,2,3,4,5,6));
    }

    @Test
    @DisplayName("n개의 수동 로또 번호 생성")
    void createManualLottoTickets() {
        List<LottoTicket> lottoTickets = LottoNumberGenerator.generateManualLottoTickets(mockManualLottoTickets, 3);
        assertThat(lottoTickets).hasSize(3);
    }

}
