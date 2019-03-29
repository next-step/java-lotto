package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.UserLottoTickets;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


public class UserLottoTicketGeneratorTest {

    class TestUserLottoTicketGenerator extends UserLottoTicketGenerator {
        //셔플값 임의로 조정
        @Override
        public void shuffleNum(List<Integer> lottoNumbers) {
            Collections.sort(lottoNumbers);
        }
    }

    @Test
    public void 내가찍은_6개_번호가_있다() {
        TestUserLottoTicketGenerator testRandomNumGenerator = new TestUserLottoTicketGenerator();

        LottoMachine lottoMachine = new LottoMachine(testRandomNumGenerator);
        UserLottoTickets userLottoTickets = lottoMachine.buyLottoTicket(new Money(1000));

        assertThat(userLottoTickets.getUserLottoTickets().size()).isEqualTo(1);
        LottoTicket lottoTicket = userLottoTickets.getUserLottoTickets().get(0);
        assertThat(lottoTicket.get(0)).isEqualTo(LottoNumber.getBasicNumber(1)); // 순서가 섞이지 않아 값 검증 가능
        assertThat(lottoTicket.get(2)).isEqualTo(LottoNumber.getBasicNumber(3));
        assertThat(lottoTicket.get(5)).isEqualTo(LottoNumber.getBasicNumber(6));
    }

    @Test
    public void 랜덤_번호_사이즈() {
        UserLottoTicketGenerator userLottoTicketGenerator = new UserLottoTicketGenerator();
        List<LottoNumber> lottoNumbers = userLottoTicketGenerator.generateTicket();
        assertThat(lottoNumbers.size()).isEqualTo(6);

    }

    @Test
    public void 사용자가_작성한_번호는_6개모두_중복되지않는다() {
        //given

        int expectedCount = 6;
        UserLottoTicketGenerator user = new UserLottoTicketGenerator();
        //when
        List<LottoNumber> pickedTickets = user.generateTicket();
        //then
        List<LottoNumber> distinctTickets = pickedTickets.stream()
            .distinct() // 중복 제거
            .collect(Collectors.toList());
        assertThat(distinctTickets.size()).isEqualTo(expectedCount);
    }

}