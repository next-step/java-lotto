package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {
    @Test
    @DisplayName("Lottos는 외부 리스트 변경으로부터 안전해야 한다(방어적 복사)")
    void defensiveCopy() {
        List<Lotto> input = new ArrayList<>();
        input.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        Lottos lottos = new Lottos(input);

        input.add(new Lotto(List.of(7, 8, 9, 10, 11, 12))); // 외부 변경

        assertThat(lottos.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("Lottos.values()는 불변 리스트를 반환한다")
    void valuesAreUnmodifiable() {
        Lottos lottos = new Lottos(List.of(
            new Lotto(List.of(1, 2, 3, 4, 5, 6))
        ));

        assertThatThrownBy(() -> lottos.values().add(new Lotto(List.of(7, 8, 9, 10, 11, 12))))
            .isInstanceOf(UnsupportedOperationException.class);
    }
}
