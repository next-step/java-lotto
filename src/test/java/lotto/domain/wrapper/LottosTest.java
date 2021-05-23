package lotto.domain.wrapper;

import lotto.domain.Lottos;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottosTest {

    @Test
    void create_로또_수동로또문자열들_입력으로_생성_Test() {
        List<String> lottosString = Arrays.asList("1,2,3,4,5,6"
                                                ,"2,3,4,5,6,7"
                                                ,"3,4,5,6,7,8"
                                                ,"4,5,6,7,8,9");

        Lottos lottos = new Lottos(lottosString);

        assertThat(lottos).isEqualTo(new Lottos(lottosString));
    }
}
