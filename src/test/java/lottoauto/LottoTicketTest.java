package lottoauto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    LottoTicket lottoTicket;

    @BeforeEach
    void setUp() {
        LottoNumbers lottoNumbers = new LottoNumbers("1,2,3,4,5,6");
        lottoTicket = new LottoTicket(lottoNumbers);
    }

    @DisplayName("티켓의 번호가 당첨번호와 몇개나 맞는지 테스트")
    @Test
    void calcHitCount() {
        LottoNumbers winningNumbers = new LottoNumbers("1,2,3,4,5,6");
        LottoNumber bonusNumber = new LottoNumber(7);
        lottoTicket.calcHitCount(new WinningNumbersWithBonus(winningNumbers, bonusNumber));
        assertThat(lottoTicket.hitCount()).isEqualTo(new HitCount(6));
        assertThat(lottoTicket.isMatchedBonus()).isFalse();


        winningNumbers = new LottoNumbers("1,2,3,4,5,10");
        bonusNumber = new LottoNumber(6);
        lottoTicket.calcHitCount(new WinningNumbersWithBonus(winningNumbers, bonusNumber));
        assertThat(lottoTicket.hitCount()).isEqualTo(new HitCount(5));
        assertThat(lottoTicket.isMatchedBonus()).isTrue();

        winningNumbers = new LottoNumbers("1,2,3,4,10,11");
        bonusNumber = new LottoNumber(5);
        lottoTicket.calcHitCount(new WinningNumbersWithBonus(winningNumbers, bonusNumber));
        assertThat(lottoTicket.hitCount()).isEqualTo(new HitCount(4));
        assertThat(lottoTicket.isMatchedBonus()).isTrue();

        winningNumbers = new LottoNumbers("1,2,3,14,15,16");
        bonusNumber = new LottoNumber(4);
        lottoTicket.calcHitCount(new WinningNumbersWithBonus(winningNumbers, bonusNumber));
        assertThat(lottoTicket.hitCount()).isEqualTo(new HitCount(3));
        assertThat(lottoTicket.isMatchedBonus()).isTrue();
    }
}
