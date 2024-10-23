package lotto.entity;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoTest {

    List<LottoNumber> toList(List<Integer> numbers) {
        return numbers.stream().map(number -> new LottoNumber(number)).collect(Collectors.toList());
    }

    Set<LottoNumber> toList(Set<Integer> numbers) {
        return numbers.stream().map(number -> new LottoNumber(number)).collect(Collectors.toSet());
    }

    @Test
    void 로또_생성_시_범위_외_번호_예외() {
        assertThatThrownBy(() -> Lotto.valueOf(toList(List.of(1, 2, 3, 4, 5, 66)))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_갯수_검증() {
        Lotto lotto = Lotto.valueOf(toList(Set.of(1, 2, 3, 10, 5, 6)));

        assertAll(
                () -> assertThat(lotto.matchCount(Lotto.valueOf(toList(Set.of(1, 43, 42, 30, 31, 33))))).isEqualTo(1),
                () -> assertThat(lotto.matchCount(Lotto.valueOf(toList(Set.of(1, 2, 3, 11, 12, 13))))).isEqualTo(3),
                () -> assertThat(lotto.matchCount(Lotto.valueOf(toList(Set.of(1, 2, 3, 5, 12, 13))))).isEqualTo(4),
                () -> assertThat(lotto.matchCount(Lotto.valueOf(toList(Set.of(1, 2, 3, 5, 12, 10))))).isEqualTo(5),
                () -> assertThat(lotto.matchCount(Lotto.valueOf(toList(Set.of(1, 2, 3, 10, 5, 6))))).isEqualTo(6)
        );
    }

    @Test
    void 중복으로_입력으로_인한_사이즈_예외() {
        assertThatThrownBy(() ->  Lotto.valueOf(toList(Arrays.asList(10, 4, 9, 2, 4, 1, 5)))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스번호_맞았는지_검증() {
        Lotto lotto =  Lotto.valueOf(toList(Set.of(1, 2, 3, 4, 5, 6)));
        assertAll(
                () -> assertThat(lotto.isCollectBonusNumber(new LottoNumber(1))).isTrue(),
                () -> assertThat(lotto.isCollectBonusNumber(new LottoNumber(7))).isFalse()
        );
    }
}
