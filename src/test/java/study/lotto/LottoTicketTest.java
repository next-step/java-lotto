package study.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.lotto.domain.LottoTicket;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoTicketTest {
    @DisplayName("로또티켓 한장에는 중복되지 않는 6개의 로또번호가 들어간다.")
    @Test
    void oneLotto() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(new LottoTicket(lottoNumbers).size()).isEqualTo(6);
    }

    @DisplayName("중복된 숫자가 포함되어 있을 경우 에러발생")
    @Test
    void duplicatedNumber() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    List<Integer> lottoNumbers =
                            Arrays.asList(1, 2, 2, 4, 5, 6);
                    new LottoTicket(lottoNumbers);
                });
    }

    @DisplayName("숫자가 총 6개가 아니면 에러발생")
    @Test
    void sixNumbers() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5);
                    new LottoTicket(lottoNumbers);
                });

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    List<Integer> lottoNumbers =
                            Arrays.asList(1, 2, 3, 4, 5, 6, 7);
                    new LottoTicket(lottoNumbers);
                });
    }

    @DisplayName("로또티켓 한장은 천원이다.")
    @Test
    void price() {
        assertThat(LottoTicket.PRICE).isEqualTo(1000);
    }
}
