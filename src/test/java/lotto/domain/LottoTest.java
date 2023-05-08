package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {
    @Test
    @DisplayName("입력 받은 숫자 6개를 정렬된 형태로 가진다.")
    void 정렬() {
        Lotto lotto = new Lotto(new ArrayList<>(Arrays.asList(20,40,30,10,5,25)));
        assertThat(lotto.equals(new ArrayList<>(Arrays.asList(5,10,20,25,30,40)))).isTrue();
    }

    @Test
    @DisplayName("숫자가 6개보다 많거나 적으면 예외를 던진다.")
    void 숫자개수() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(new ArrayList<>(Arrays.asList(1)));
        });

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(new ArrayList<>(Arrays.asList(1,1,1,1,1,1,1)));
        });
    }

    @Test
    @DisplayName("모든 숫자가 1과 45 사이의 수가 아니면 예외를 던진다.")
    void 숫자범위() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(new ArrayList<>(Arrays.asList(0,1,2,3,4,5)));
        });

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(new ArrayList<>(Arrays.asList(41,42,43,44,45,46)));
        });
    }
}
