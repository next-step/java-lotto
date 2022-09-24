package lotto.step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {
    private List<LottoNumber> ascendingLottoNumbers;
    private LottoTicket lottoTicket;
    
    @BeforeEach
    void setUp() {
        ascendingLottoNumbers = IntStream.rangeClosed(1, 6)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
        lottoTicket = new LottoTicket(ascendingLottoNumbers);
    }
    
    @Test
    @DisplayName("로또 티켓 한 장 생성")
    void create() {
        assertThat(lottoTicket).isEqualTo(new LottoTicket(ascendingLottoNumbers));
    }
    
    @Test
    @DisplayName("로또 번호 6개 일치 확인")
    void confirm_six_number_match() {
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));
        int result = lottoTicket.confirmNumberMatch(winningLottoNumbers);
        assertThat(result).isEqualTo(6);
    }
    
    @Test
    @DisplayName("로또 번호 5개 일치 확인")
    void confirm_five_number_match() {
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(7), new LottoNumber(5), new LottoNumber(6)));
        int result = lottoTicket.confirmNumberMatch(winningLottoNumbers);
        assertThat(result).isEqualTo(5);
    }
    
    @Test
    @DisplayName("로또 번호 4개 일치 확인")
    void confirm_four_number_match() {
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(7), new LottoNumber(8), new LottoNumber(6)));
        int result = lottoTicket.confirmNumberMatch(winningLottoNumbers);
        assertThat(result).isEqualTo(4);
    }
    
    @Test
    @DisplayName("로또 번호 3개 일치 확인")
    void confirm_three_number_match() {
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(7), new LottoNumber(8), new LottoNumber(9)));
        int result = lottoTicket.confirmNumberMatch(winningLottoNumbers);
        assertThat(result).isEqualTo(3);
    }
}