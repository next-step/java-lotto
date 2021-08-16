package lotto.domain;

import lotto.domain.LottoResult;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketResultTest {

    @Test
    public void expect와_hits를_통해_보상액을_구할_수_있다(){
        //given
        LottoResult lottoResult = new LottoResult(Ranking.FIFTH, 3);
        //when
        int result = lottoResult.calculateCompensation();
        //then
        assertThat(result).isEqualTo(15000);
    }
}