package lotto.domain;

import lotto.domain.numbers.LottoNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketFactoryTest {
    private LottoTicketFactory lottoTicketFactory;

    @BeforeEach
    void setUp() {
        lottoTicketFactory = new LottoTicketFactory();
    }

    @DisplayName("로또 뽑기에 사용할 1부터 45까지 숫자(LottoNumber)를 미리 생성한다.")
    @Test
    void make_init_LottoNumbers() {
        List<LottoNumber> lottoNumbers = lottoTicketFactory.getLottoNumbers();

        assertThat(lottoNumbers).hasSize(45);

        for (int number = 0; number < 45; number++) {
            assertThat(lottoNumbers.get(number)).isEqualTo(new LottoNumber(number + 1));
        }
    }

    @DisplayName("랜덤으로 돌려 6개 숫자를 뽑아 크기 순으로 정렬한다.")
    @Test
    void make_LottoTicket() {
        List<LottoNumber> lottoNumbers = lottoTicketFactory.makeAutoLottoTicket().getLottoNumbers();

        assertThat(lottoNumbers).hasSize(6);

        for (int index = 1; index < 6; index++) {
            assertThat(lottoNumbers.get(index - 1).getValue() < lottoNumbers.get(index).getValue()).isTrue();
        }

    }
}
