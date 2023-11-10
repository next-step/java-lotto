package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoTest {

    @Test
    void 입력된_숫자가_리스트에_있는지_알_수_있다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertAll(
                () -> {
                    boolean actual = lotto.contains(1);

                    assertThat(actual).isTrue();
                },
                () -> {
                    boolean actual = lotto.contains(7);

                    assertThat(actual).isFalse();
                }
        );
    }

}
