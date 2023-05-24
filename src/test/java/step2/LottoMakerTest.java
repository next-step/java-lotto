package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class LottoMakerTest {

    private LottoMaker lottoMaker;

    @BeforeEach
    public void init() {
        lottoMaker = new LottoMaker();
    }

    @ParameterizedTest
    @CsvSource(value = {"14000:14", "1000:1", "3000:3"}, delimiter = ':')
    void 티켓장수조회테스트(int input, int expected) {
        assertThat(lottoMaker.getLottoTicketCount(input)).isEqualTo(expected);
    }


    @Test
    public void 싱글티켓만들기테스트_로또넘버범위와길이(){
        LottoTicket lottoTicket = lottoMaker.buySingleLottoTicket();
        assertThat(lottoTicket.getNumbers().size()).isEqualTo(LottoMaker.LOTTO_PICK_COUNT);
       lottoTicket.getNumbers().forEach(x -> assertThat(x).isBetween(LottoMaker.LOTTO_START_NUMBER, LottoMaker.LOTTO_LAST_NUMBER));
    }

    @ParameterizedTest
    @CsvSource(value = {"14:14", "1:1", "3:3"}, delimiter = ':')
    void 티켓복수개생성테스트(int input, int expected) {
        assertThat(lottoMaker.buyLottoTickets(input).size()).isEqualTo(expected);

    }



}
