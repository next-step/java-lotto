package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoTest {

    @DisplayName("로또가 생성된다.")
    @Test
    void createLotto() {
        Lotto lotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto).isEqualTo(new Lotto(Set.of(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("로또의 값을 변경시키면 에러를 반환한다.")
    @Test
    void changeLottoNumber() {
        Lotto lotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));
        List<LottoNumber> lottos = lotto.getLotto();
        assertThatExceptionOfType(UnsupportedOperationException.class)
                .isThrownBy(() -> {
                    lottos.add(new LottoNumber(7));
                });
    }

    @DisplayName("로또의 개수가 맞지 않을 경우 에러를 반환한다.")
    @Test
    void validateLottoSize() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Lotto(Set.of(1, 2, 3, 4, 5));
                    new Lotto(Set.of(1, 2, 3, 4, 5, 6, 7));
                    new Lotto(Set.of(1, 2, 3, 4, 5, 5));
                });
    }

    @DisplayName("로또 맞은 개수 반환한다.")
    @Test
    void countMatchNumber() {
        Lotto lotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));
        int count = lotto.countMatchNumber(new Lotto(Set.of(1, 2, 3, 7, 8, 9)));
        assertThat(count).isEqualTo(3);
    }
}
