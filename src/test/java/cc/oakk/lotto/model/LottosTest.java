package cc.oakk.lotto.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottosTest {
    @Test
    public void constructor_ShouldThrow_OnNullElement() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lottos(Arrays.asList(
                new Lotto(Arrays.asList(1, 2,3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 3, 5, 7, 9,  11)),
                new Lotto(Arrays.asList(1, 4, 8, 12, 16, 20)),
                new Lotto(Arrays.asList(1, 14, 18, 22, 26, 30)),
                null)));
    }

    @Test
    public void add() {
        Lottos lottos = new Lottos();
        lottos.add(new Lotto(Arrays.asList(1, 2,3, 4, 5, 6)))
                .add(new Lotto(Arrays.asList(1, 3, 5, 7, 9,  11)))
                .add(new Lotto(Arrays.asList(1, 4, 8, 12, 16, 20)))
                .add(new Lotto(Arrays.asList(1, 14, 18, 22, 26, 30)));

        assertThat(lottos).isEqualTo(new Lottos(Arrays.asList(
                new Lotto(Arrays.asList(1, 2,3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 3, 5, 7, 9,  11)),
                new Lotto(Arrays.asList(1, 4, 8, 12, 16, 20)),
                new Lotto(Arrays.asList(1, 14, 18, 22, 26, 30)))));

        assertThatIllegalArgumentException().isThrownBy(() -> lottos.add(null));
    }
}
