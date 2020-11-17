package step02.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottosTest {
    @DisplayName("생성자 테스트")
    @Test
    public void test_Lottos_Constructor() {
        List<Lotto> lottos = new ArrayList<Lotto>(
                Arrays.asList(
                        Lotto.of(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))),
                        Lotto.of(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))),
                        Lotto.of(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)))
                )
        );
        assertThat(Lottos.of(lottos)).isEqualTo(Lottos.of(lottos));
    }
}
