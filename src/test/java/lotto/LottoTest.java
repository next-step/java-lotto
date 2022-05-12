package lotto;

import lotto.model.Lotto;
import lotto.model.LottoNumber;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Sets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static lotto.LottoNumberTest.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또 번호 6개를 담는 lotto 클래스 테스트")
public class LottoTest {

    public static final Lotto TEST_LOTTO = new Lotto(Sets.newLinkedHashSet(ONE, TWO, THREE, FOUR, FIVE, SIX));

    @Test
    @DisplayName("로또 번호를 입력한 문자열로 로또를 생성한다.")
    void stringLottoGenerateTest() {
        // given
        Lotto lotto = new Lotto("1, 2, 3, 4, 5, 6");
        Set<LottoNumber> lottoNumbers = Sets.newHashSet(lotto.get());

        // when
        lottoNumbers.retainAll(TEST_LOTTO.get());
        // then
        assertThat(lottoNumbers).hasSize(6);
    }

    @Test
    @DisplayName("lotto 생성시 null이 들어오면 NullPointerException이 발생한다.")
    void nullTest() {
        Assertions.assertThatThrownBy(() -> new Lotto((String) null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("lotto 생성시 사이즈가 6이 아닌 수가 들어오면 예외가 발생한다.")
    void sizeTest() {
        Assertions.assertThatThrownBy(() -> new Lotto(Sets.newLinkedHashSet(ONE, TWO, THREE)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호가 특정 로또 넘버를 포함하면 true를 반환한다.")
    void containsTrueTest() {
        assertThat(TEST_LOTTO.contains(ONE)).isTrue();
    }

    @Test
    @DisplayName("로또 번호가 특정 로또 넘버를 포함하지 않으면 false를 반환한다.")
    void containsFalseTest() {
        assertThat(TEST_LOTTO.contains(LottoNumber.valueOf(11))).isFalse();
    }

    @Test
    @DisplayName("현재 로또와 입력 로또의 matchCount를 반환할 때 null이 들어오면 예외가 발생한다.")
    void matchCountNullTest() {
        Lotto fourMatchLotto = new Lotto(Sets.newLinkedHashSet(ONE, TWO, THREE, FOUR, LottoNumber.valueOf(10), LottoNumber.valueOf(11)));

        assertThatThrownBy(() -> fourMatchLotto.countMatchNumber(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("null일 수 없습니다.");
    }

    @Test
    @DisplayName("현재 로또와 입력 로또의 matchCount를 반환한다.")
    void matchCountTest() {
        Lotto fourMatchLotto = new Lotto(Sets.newLinkedHashSet(ONE, TWO, THREE, FOUR, LottoNumber.valueOf(10), LottoNumber.valueOf(11)));

        assertThat(fourMatchLotto.countMatchNumber(TEST_LOTTO)).isEqualTo(4);
    }
}
