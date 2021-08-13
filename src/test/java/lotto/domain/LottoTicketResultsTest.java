package lotto.domain;

import lotto.domain.LottoResult;
import lotto.domain.LottoResults;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketResultsTest {
    @Test
    public void 구매금액과_로또결과가_주어지면_수익률을_구할_수_있다(){
        //given
        LottoResults lottoResults = new LottoResults();
        lottoResults.addAll(
                new LottoResult(3, 3),  // 15000
                new LottoResult(4, 1),  // 50000
                new LottoResult(5, 1),  // 1500000
                new LottoResult(6, 0)
        );
        //when
        double earningLate = lottoResults.getEarningLate(100000);
        //then
        assertThat(earningLate).isEqualTo(15.65);
    }
}