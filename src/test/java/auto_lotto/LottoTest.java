package auto_lotto;

import auto_lotto.domain.LottoTickets;
import auto_lotto.domain.LottoTicket;
import auto_lotto.domain.RandomNumber;
import auto_lotto.domain.VendingMachine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoTest {

    @Test
    public void 장당_1000원의_로또를_계산하여_발권(){
        int money = 14000;
        int priceOfLotto = 1000;
        VendingMachine vendingMachine = new VendingMachine();
        LottoTickets lottoTickets = vendingMachine.insert(money);
        assertThat(lottoTickets.getLottoTickets().size()).isEqualTo(money/priceOfLotto);
    }

    @Test
    public void 로또는임의의5개의번호를가져야한다(){
        RandomNumber randomNumber = new RandomNumber();
        LottoTicket lottoTicket = new LottoTicket(randomNumber);
        assertThat(lottoTicket.getNumbers().size()).isEqualTo(5);
    }

    @Test
    public void 로또는임의의5개의숫자는중복될수없다(){
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
