package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
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

    @Test
    void size() {
        //given
        Lottos lottos = TestObjectSupport.createLottos();

        //when
        int result = lottos.size();

        //then
        assertThat(result).isEqualTo(3);
    }

    @Test
    void toList() {
        //given
        Lottos lottos = TestObjectSupport.createLottos();
        Lotto lotto = TestObjectSupport.createLotto();
        List<Lotto> expectedLottos = Arrays.asList(lotto, lotto, lotto);

        //when
        List<Lotto> result = lottos.toList();

        //then
        assertThat(result).isEqualTo(expectedLottos);
    }

    @Test
    void totalPrice() {
        //given
        Lottos lottos = TestObjectSupport.createLottos();
        Cash expectedPrice = new Cash(3000);

        //when
        Cash result = lottos.totalPrice();

        //then
        assertThat(result).isEqualTo(expectedPrice);
    }
}
