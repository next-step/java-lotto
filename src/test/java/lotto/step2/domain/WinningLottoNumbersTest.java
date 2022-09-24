package lotto.step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoNumbersTest {
    private WinningLottoNumbers winningLottoNumbers;
    
    @BeforeEach
    void setUp() {
        List<LottoNumber> lottoNumbers = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        winningLottoNumbers = new WinningLottoNumbers(lottoNumbers);
    }
    
    @Test
    @DisplayName("6개의 번호 일치 확인")
    void confirm_six_number_match() {
        List<LottoNumber> issuedLottoNumbers = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        int result = winningLottoNumbers.confirmNumberMatch(issuedLottoNumbers);
        assertThat(result).isEqualTo(6);
    }
    
    @Test
    @DisplayName("5개의 번호 일치 확인")
    void confirm_five_number_match() {
        List<LottoNumber> issuedLottoNumbers = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(7), new LottoNumber(5), new LottoNumber(6));
        int result = winningLottoNumbers.confirmNumberMatch(issuedLottoNumbers);
        assertThat(result).isEqualTo(5);
    }
    
    @Test
    @DisplayName("4개의 번호 일치 확인")
    void confirm_four_number_match() {
        List<LottoNumber> issuedLottoNumbers = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(7), new LottoNumber(8), new LottoNumber(6));
        int result = winningLottoNumbers.confirmNumberMatch(issuedLottoNumbers);
        assertThat(result).isEqualTo(4);
    }
    
    @Test
    @DisplayName("3개의 번호 일치 확인")
    void confirm_three_number_match() {
        List<LottoNumber> issuedLottoNumbers = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(7), new LottoNumber(8), new LottoNumber(9));
        int result = winningLottoNumbers.confirmNumberMatch(issuedLottoNumbers);
        assertThat(result).isEqualTo(3);
    }
}