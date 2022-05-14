package domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    @Test
    void create() {
        //given
        Lotto lotto = TestObjectSupport.createLotto();
        List<Lotto> lottos = List.of(lotto);

        //when
        Lottos result = new Lottos(lottos);

        //then
        assertThat(result).isEqualTo(new Lottos(lottos));
    }
}
