package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LottoTest {

    @Test
    @DisplayName("로또 번호 6개로 생성할 수 있다.")
    void createSuccess() {
        /* given */
        final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        /* when & then */
        assertDoesNotThrow(() -> new Lotto(numbers));
    }

    @Test
    @DisplayName("로또 번호가 6개가 아닌 경우 IllegalArgumentException을 던진다.")
    void createFailWithNotSixLottoNumber() {
        /* given */
        final List<Integer> sevenNumbers = List.of(1, 2, 3, 4, 5, 6, 7);
        final List<Integer> fiveNumbers = List.of(1, 2, 3, 4, 5);
        final List<Integer> emptyNumbers = Collections.emptyList();

        /* when & then */
        assertThatThrownBy(() -> new Lotto(sevenNumbers)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(fiveNumbers)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(emptyNumbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호가 중복일 경우 IllegalArgumentException을 던진다.")
    void createFailWithDuplicatedLottoNumber() {
        /* given */
        final List<Integer> duplicatedNumbers = List.of(1, 2, 3, 4, 5, 5);

        /* when & then */
        assertThatThrownBy(() -> new Lotto(duplicatedNumbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 간의 일치 번호 개수를 출력한다.")
    void countMatchLottoNumber() {
        /* given */
        final Lotto origin = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        final Lotto target = new Lotto(List.of(4, 5, 1, 2, 6, 3));

        /* when */
        final long count = origin.countMatchLottoNumber(target);

        /* then */
        assertThat(count).isEqualTo(6);
    }

}
