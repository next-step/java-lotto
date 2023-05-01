package lotto;

import lotto.domain.LottoGenerator;
import lotto.domain.LottoTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {
    @DisplayName("구입 금액에 해당하는 로또번호(자동)을 발급한다")
    @Test
    void generate() {
        LottoTickets lottoTickets = LottoGenerator.generate(3);
        assertThat(lottoTickets.size()).isEqualTo(3);
    }

    @DisplayName("수동 로또번호와 전체 발급개수를 받아 로또티켓을 발급한다")
    @Test
    void issue() {
        List<Integer> manualLottoNumber1 = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> manualLottoNumber2 = List.of(6, 7, 8, 9, 10, 11);

        LottoTickets lottoTickets = LottoGenerator.issue(3, List.of(manualLottoNumber1, manualLottoNumber2));
        assertThat(lottoTickets.size()).isEqualTo(3);
    }
}
