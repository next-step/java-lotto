package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningStatisticsResolverTest {

    @Test
    public void 보상액과_투자액을_받아서_수익률을_계산할_수_있다(){
        //given
        WinningStatisticsResolver resolver = new WinningStatisticsResolver();
        //when
        double winning = resolver.resolve(100000, 1000000);
        //then
        assertThat(winning).isEqualTo(0.1);
    }
}
