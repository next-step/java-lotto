package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.LottoTicket;
import step2.domain.LottoTickets;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoTicketsTest {

    @Test
    @DisplayName("로또 객체가 리스트에 제대로 담겼는지 로또 장수 테스트")
    void checkTheNumberOfLottoTickets() {
        // given
        int numberOfLotto = 5;

        // when
        LottoTickets lottoCollections = new LottoTickets(numberOfLotto, new AutoLottoNumberGenerator());
        List<LottoTicket> lottoTickets = lottoCollections.getLottoTickets();
        int actual = lottoTickets.size();

        // then
        assertEquals(numberOfLotto, actual);
    }

    @Test
    @DisplayName("수동으로 추가한 로또 객체가 리스트에 제대로 담겼는지 테스트")
    void isSaveLottoInList(){
        // given
        List<Integer> expected = Arrays.asList(1,2,44,7, 17, 21);
        LottoNumberGenerator lottoNumberGenerator = new TestLottoNumberGenerator(expected);

        // when
        LottoTickets lottoCollection = new LottoTickets(expected.size(),lottoNumberGenerator);
        List<LottoTicket> lottoTickets = lottoCollection.getLottoTickets();
        LottoTicket lottoNumbers = lottoTickets.get(0);
        List<Integer> actual = lottoNumbers.getLottoNumbers();

        // then
        assertEquals(expected, actual);
    }
}
