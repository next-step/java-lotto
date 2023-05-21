package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static util.LottoTestHelper.parse;

class LottoTest {

    @Test
    @DisplayName("로또 번호로 로또 생성")
    void createByNumbers() {
        final List<LottoNumber> allLottoNumbers = LottoNumber.allLottoNumbers();
        Collections.shuffle(allLottoNumbers);

        new Lotto(allLottoNumbers.stream()
            .limit(Lotto.needLottoNumberCount.value())
            .collect(Collectors.toList()));
    }

    @Test
    @DisplayName("잘못된 개수의 로또 번호로 로또 생성")
    void createByNumbersFail() {
        final List<LottoNumber> allLottoNumbers = LottoNumber.allLottoNumbers();
        Collections.shuffle(allLottoNumbers);

        Assertions.assertThatThrownBy(() -> new Lotto(allLottoNumbers.stream()
            .limit(Lotto.needLottoNumberCount.value() + 1)
            .collect(Collectors.toList())))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("같은 로또 번호로 포함 여부를 검증할 수 있음")
    void contains() {
        final Lotto lotto = new Lotto(parse("1,2,3,4,5,6"));

        Assertions.assertThat(lotto.contains(new LottoNumber("1"))).isTrue();
        Assertions.assertThat(lotto.contains(new LottoNumber("7"))).isFalse();
    }

    @Test
    @DisplayName("서로 다른 로또끼리 비교하여 일치하는 번호의 개수를 반환")
    void match() {
        final Lotto lotto = new Lotto(parse("1, 2, 3, 4, 5, 6"));
        final Lotto other = new Lotto(parse("1, 2, 3, 4, 5, 7"));

        Assertions.assertThat(lotto.matchCount(other)).isEqualTo(5);
    }

    @Test
    @DisplayName("로또 번호는 중복될 수 없다")
    void duplicate() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(
            new LottoNumber("1"),
            new LottoNumber("1"),
            new LottoNumber("2"),
            new LottoNumber("3"),
            new LottoNumber("4"),
            new LottoNumber("5")
        ))).isInstanceOf(IllegalArgumentException.class);
    }
}