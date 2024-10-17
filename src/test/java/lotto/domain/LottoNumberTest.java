package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumberTest {
    @DisplayName("LottoNumber 객체의 동등성 비교 시 객체의 실제 값을 비교한다.")
    @Test
    void equals_to_value() {
        LottoNumber actual = new LottoNumber(1);

        assertThat(actual)
                .isEqualTo(new LottoNumber(1))
                .isNotSameAs(new LottoNumber(1));
    }

    @DisplayName("로또 번호는 1~45 사이의 숫자여야 한다.")
    @ParameterizedTest(name = "LottoNumber: {0}")
    @ValueSource(ints = {0, 46})
    void throw_IllegalArgumentException_when_lottoNumber_is_not_between_1_and_45(int given) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(given))
                .withMessage("로또 번호는 1~45 사이의 숫자여야 합니다.");
    }

    @DisplayName("LottoNumber 타입의 리스트를 정렬하면, LottoNumber 내 인스턴스 필드를 기준으로 정렬한다.")
    @Test
    void sort() {
        List<LottoNumber> lotto = new ArrayList<>(Arrays.asList(new LottoNumber(40), new LottoNumber(30), new LottoNumber(20)));

        Collections.sort(lotto);

        assertThat(lotto).containsExactly(new LottoNumber(20), new LottoNumber(30), new LottoNumber(40));
    }

    @DisplayName("객체에 대해 깊은 복사하여 반환한다.")
    @Test
    void deepCopy() {
        LottoNumber given = new LottoNumber(1);

        LottoNumber actual = given.deepCopy();

        assertThat(actual).isEqualTo(given)
                .isNotSameAs(given);
    }
}
