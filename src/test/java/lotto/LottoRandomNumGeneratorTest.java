package lotto;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoRandomNumGeneratorTest {

    class LottoRandomNumGeneratorTestClass extends LottoRandomNumGenerator {
        //셔플값 임의로 조정
        @Override
        protected void shuffleNum(List<Integer> lottoNumbers) {
            Collections.sort(lottoNumbers);
        }
    }
    @Test
    public void  내가찍은_6개_번호가_있다() {
        LottoRandomNumGeneratorTestClass testClass = new LottoRandomNumGeneratorTestClass();

        LottoMachine lottoMachine = new LottoMachine(testClass);
        List<LottoTicket> lottoTickets = lottoMachine.buyLottoTicket(1000);

        assertThat(lottoTickets.size()).isEqualTo(1);
        LottoTicket lottoTicket = lottoTickets.get(0);

        assertThat(lottoTicket.get(0)).isEqualTo(1); // 순서가 섞이지 않아 값 검증 가능
        assertThat(lottoTicket.get(2)).isEqualTo(3);
        assertThat(lottoTicket.get(5)).isEqualTo(6);
    }

    @Test
    public void 랜덤_번호_사이즈_확인() {
        LottoRandomNumGenerator lottoRandomNumGenerator = new LottoRandomNumGenerator();
        List<Integer> integers = lottoRandomNumGenerator.generateTicket();

        assertThat(integers.size()).isEqualTo(6);
    }






}