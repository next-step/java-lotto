package auto_lotto;

import auto_lotto.domain.LottoTicket;
import auto_lotto.domain.LottoVendingMachine;
import auto_lotto.domain.RandomNumbers;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoTest {

    @Test
    public void 장당_1000원의_로또를_계산하여_발권(){
        int money = 14000;
        int priceOfLotto = 1000;
        LottoVendingMachine lottoVendingMachine = new LottoVendingMachine();
        List<LottoTicket> lottoTickets = lottoVendingMachine.receive(money);
        assertThat(lottoTickets.size()).isEqualTo(money/priceOfLotto);
    }

    @Test
    public void 임의의_5개의_번호를_가져야한다(){
        RandomNumbers randomNumbers = new RandomNumbers();
        LottoTicket lottoTicket = new LottoTicket(randomNumbers);
        assertThat(lottoTicket.getNumbers().size()).isEqualTo(5);
    }

    @Test
    public void 임의의_5개의_숫자는_중복_될_수_없다(){
        LottoTicket lottoTicket = new LottoTicket(List.of(1,1,3,4,5));
        List<Integer> riddle = lottoTicket.getNumbers();
        assertTrue(hasDuplicates(riddle));
    }

    public static boolean hasDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (Integer number : numbers) {
            if (!uniqueNumbers.add(number)) {
                return true;
            }
        }
        return false;
    }
}
