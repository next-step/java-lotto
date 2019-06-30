package lotto.domain.ticket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoTicketTest {

    @Test
    @DisplayName("로또번호 개수가 6개인경우 정상적으로 생성하는지 확인한다")
    void checkNumberCount() {
        // given
        LottoTicket lottoTicket = LottoTicket.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L), 45);
        // when
        List<LottoNumber> lottoNumbers = lottoTicket.findAll();
        // then
        assertThat(lottoNumbers.size()).isEqualTo(6);
        assertThat(lottoNumbers.get(0).get()).isEqualTo(1L);
        assertThat(lottoNumbers.get(1).get()).isEqualTo(2L);
        assertThat(lottoNumbers.get(2).get()).isEqualTo(3L);
        assertThat(lottoNumbers.get(3).get()).isEqualTo(4L);
        assertThat(lottoNumbers.get(4).get()).isEqualTo(5L);
        assertThat(lottoNumbers.get(5).get()).isEqualTo(6L);
    }

    @Test
    @DisplayName("로또번호 개수가 5개인경우 예외처리를 확인한다")
    void checkNumberCount2() throws Exception {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    LottoTicket.of(Arrays.asList(1L, 2L, 3L, 4L, 5L), 45);
                }).withMessageMatching("Count of Lotto numbers must be 6");
    }

    @Test
    @DisplayName("로또번호 개수가 7개인경우 예외처리를 확인한다")
    void checkNumberCount3() throws Exception {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    LottoTicket.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L, 7L), 45);
                }).withMessageMatching("Count of Lotto numbers must be 6");
    }

    @Test
    @DisplayName("로또번호가 중복된경우 예외처리를 확인한다")
    void checkDuplicatedNumber() throws Exception {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    LottoTicket.of(Arrays.asList(2L, 2L, 3L, 4L, 5L, 6L), 45);
                }).withMessageMatching("Lotto numbers can not be duplicated");
    }

    @Test
    @DisplayName("보너스번호를 정상적으로 생성하는지 확인한다")
    void checkBonusNumber() {
        // given
        LottoTicket lottoTicket = LottoTicket.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L), 45);
        // when
        LottoNumber bonusNumber = lottoTicket.getBonusNumber();
        // then
        assertThat(bonusNumber.get()).isEqualTo(45L);
    }
}
