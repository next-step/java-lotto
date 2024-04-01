package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.LottoVendingMachine;
import lotto.domain.RandomNumbers;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

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
    public void 임의의_6개의_번호를_가져야한다(){
        LottoTicket lottoTicket = new LottoTicket(1,2,3,4,5,6);
        assertThat(lottoTicket.getLottoNumbers()).isEqualTo(6);
    }

    @Test
    public void 임의의_6개의_숫자는_중복_될_수_없다(){
        LottoTicket lottoTicket = new LottoTicket(1,1,3,4,5,6);
        List<Integer> lottoNumbers = lottoTicket.getLottoNumbers().stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());
        assertTrue(hasDuplicates(lottoNumbers));
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
