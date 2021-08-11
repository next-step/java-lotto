package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ChanceResolverTest {

    @Test
    public void 로또_구매금액을_받아서_진행횟수를_구해낼_수_있다(){
        //given
        ChanceResolver resolver = new ChanceResolver();
        //when
        int chance = resolver.resolveFromPurchaseAmount(15000);
        //then
        assertThat(chance).isEqualTo(15);
    }
}
