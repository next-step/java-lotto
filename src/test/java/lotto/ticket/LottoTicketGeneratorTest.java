package lotto.ticket;

import lotto.domain.LottoNumber;
import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.LottoTicketAutoGenerator;
import lotto.domain.ticket.LottoTicketManualGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class LottoTicketGeneratorTest {

    private LottoTicketAutoGenerator lottoGenerator;

    @BeforeEach
    void setUp() {
        lottoGenerator = new LottoTicketAutoGenerator();
    }

    @Test
    @DisplayName("로또 생성기를 생성하는데 어떤 에러도 발생하지 않는다.")
    void 로또_생성기_생성_테스트() {
        assertThatCode(() -> new LottoTicketAutoGenerator()).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("로또를 자동으로 생성하고 결과크기를 검증한다.")
    void 로또_자동_생성_테스트() {
        LottoTicket lotto = lottoGenerator.generate(LottoNumber.getDefaultLottoNumbers());
        assertThat(lotto.getLottoNumbers()).hasSize(6);
    }

    @Test
    @DisplayName("로또를 자동 생성하고 중복번호가 있는지 검증한다.")
    void 로또_중복_테스트() {
        LottoTicket lotto = lottoGenerator.generate(LottoNumber.getDefaultLottoNumbers());
        assertThat(lotto.getLottoNumbers().size()).isEqualTo(new HashSet<>(lotto.getLottoNumbers()).size());
    }

    @Test
    @DisplayName("로또 수동 생성기를 생성하는데 어떤 에러도 발생하지 않는다.")
    void 로또_수동_생성기_생성_테스트() {
        assertThatCode(() -> new LottoTicketManualGenerator()).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("로또 수동 번호를 생성하고 LottoTicket을 반환한다.")
    void 로또_수동_번호_생성_테스트() {
        LottoTicket lottoTicket = new LottoTicketManualGenerator().generate(LottoNumber.of(1, 2, 3, 4, 5, 6));
        assertThat(lottoTicket).isNotNull();
    }
}
