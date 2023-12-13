package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LottoTicketTest {
    @Test
    @DisplayName("입력받은 숫자와 로또 티켓의 사이즈는 같아야한다.")
    void size() {
        LottoTicket lottoTicket = new LottoTicket(3);
        Assertions.assertThat(lottoTicket.getLottoTicket()).hasSize(3);
    }

    @Test
    @DisplayName("수동로또와 자동로또를 함께 생성할 수 있다")
    void merge() {
        List<Integer> lottoNumbers1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> lottoNumbers2 = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto1 = new Lotto(lottoNumbers1);
        Lotto lotto2 = new Lotto(lottoNumbers2);
        int number = 4;
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(lotto1, lotto2), number);
        Assertions.assertThat(lottoTicket.getLottoTicket()).hasSize(6);
    }
}
