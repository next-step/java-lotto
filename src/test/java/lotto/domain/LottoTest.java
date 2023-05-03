package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @DisplayName("정상적인 숫자 입력으로 로또 생성 테스트")
    @Test
    void generateLottoFromValidNumbers() {
        Set<LottoNumber> lottoNumbers = Set.of(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)
        );
        assertThatNoException().isThrownBy(() -> Lotto.from("1, 2, 3, 4, 5, 6"));
        assertThatNoException().isThrownBy(() -> Lotto.of(lottoNumbers));
    }

    @DisplayName("중복된 숫자 입력으로 로또 생성 테스트")
    @Test
    void generateLottoFromDuplicatedNumbers() {
        assertThatThrownBy(() -> Lotto.from("1, 2, 3, 4, 5, 5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자 개수가 일치하지 않는 로또 생성 테스트")
    @Test
    void generateLottoOfInvalidNumbers() {
        Set<LottoNumber> outNumbered = Set.of(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6),
                LottoNumber.of(7)
        );
        Set<LottoNumber> shortened = Set.of(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5)
        );

        assertThatThrownBy(() -> Lotto.of(outNumbered))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Lotto.of(shortened))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자 개수가 일치하지 않는 로또 생성 테스트 2")
    @Test
    void generateLottoFromInvalidNumbers() {
        assertThatThrownBy(() -> Lotto.from("1, 2, 3, 4, 5, 6, 7"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Lotto.from("1, 2, 3, 4, 5"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
