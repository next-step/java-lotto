package lotto.domain.strategy;

import lotto.domain.item.LottoNumber;
import lotto.domain.item.LottoNumbers;
import lotto.domain.item.LottoTickets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketGeneratorTest {

    private List<LottoNumber> numbers;

    @BeforeEach
    void setUp() {
        numbers = new ArrayList<>(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));
    }

    @DisplayName("주어진 수 만큼 랜덤 로또를 만들어 낸다")
    @Test
    public void lottoTicketGenerate_success() throws Exception {
        //given
        LottoTickets tickets = LottoTicketGenerator.generateAutoLotto(3);

        //then
        assertThat(tickets.size()).isEqualTo(3);
    }

    @DisplayName("수동으로 입력한 번로를 이용하여 로또 티켓 생성")
    @Test
    public void generatePassivityLotto_sucess() throws Exception {
        //given
        LottoNumbers lottoNumbers1 = LottoNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumbers lottoNumbers2 = LottoNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<LottoNumbers> numbers =
                new ArrayList<>(Arrays.asList(lottoNumbers1, lottoNumbers2));

        //when
        LottoTickets tickets = LottoTicketGenerator.generatePassivityLotto(numbers);


        //then
        assertThat(tickets.size()).isEqualTo(2);
    }
}
