package lotto.common;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @Test
    public void expect와_hits를_통해_보상액을_구할_수_있다(){
        //given
        LottoResult lottoResult = new LottoResult(3, 3);
        //when
        int result = lottoResult.calculateCompensation();
        //then
        assertThat(result).isEqualTo(15000);
    }
}