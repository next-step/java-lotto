package lotto.service.factory;

import lotto.service.domain.LottoTicket;
import lotto.service.domain.factory.LottoTicketFactory;
import lotto.service.value.LottoNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketFactoryTest {

    LottoTicketFactory lottoTicketFactory;

    @BeforeEach
    void setup() {
        lottoTicketFactory = new LottoTicketFactory();
    }

    @Test
    @DisplayName("수동 방식 로또복권 생성 확인")
    void createLottoTicketByManual() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        LottoTicket lottoTicket = lottoTicketFactory.createLottoTicketByManual(lottoNumbers);
        assertThat(lottoTicket).isNotNull();

        lottoNumbers.forEach(number
                                     -> assertThat(lottoTicket.isContains(LottoNumber.from(number))).isTrue());
    }

    @Test
    @DisplayName("랜덤 방식 로또복권 생성 확인")
    void createLottoTicketByAuto() {
        LottoTicket lottoTicket = lottoTicketFactory.createLottoTicketByAuto();
        assertThat(lottoTicket).isNotNull();
    }
}
