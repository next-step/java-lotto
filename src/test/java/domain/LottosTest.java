package domain;

import org.junit.Test;
import util.WinType;

import java.util.Arrays;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    @Test
    public void 로또_당첨_확인() {
        Lottos lottos = new Lottos(Arrays.asList(
                Lotto.of(15, 22, 18, 43, 41, 2),
                Lotto.of(5, 33, 1, 43, 41, 32),
                Lotto.of(2, 32, 18, 4, 42, 6),
                Lotto.of(34, 42, 18, 43, 1, 2)
        ));

        Map<WinType, Long> map = lottos.figure(new WinningLotto(Lotto.of(5, 33, 1, 43, 41, 32), 12));

        assertThat(map.get(WinType.FIRST)).isEqualTo(1);
    }


    @Test
    public void 문자로_입력시_정상동작() {
        String input = "1,2,3,4,5,6";
        Lotto numbers = Lotto.of(input.split(","));

        assertThat(numbers.hasNumber(1)).isTrue();
        assertThat(numbers.hasNumber(2)).isTrue();
        assertThat(numbers.hasNumber(3)).isTrue();
        assertThat(numbers.hasNumber(4)).isTrue();
        assertThat(numbers.hasNumber(5)).isTrue();
        assertThat(numbers.hasNumber(6)).isTrue();
    }

    @Test
    public void 같은_번호_갯수_카운트() {
        Lotto numbers = Lotto.of(1, 2, 3, 4, 5, 6);
        Lotto newNumbers = Lotto.of(1, 2, 3, 4, 5, 10);

        assertThat(numbers.count(newNumbers)).isEqualTo(5);
    }
}