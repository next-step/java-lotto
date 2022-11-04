package Lotto;

import lotto.Lotto;
import lotto.LottoNumber;
import lotto.WinningLotto;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningLottoTest {
    @Test
    void create() {
        assertThat(new WinningLotto(numbers(1, 7), 7)).isInstanceOf(Lotto.class);
    }

    @Test
    void 교집합으로_숫자_추리기() {
        assertThat(new WinningLotto(numbers(1, 7), 7).correctCount(new Lotto(numbers(1, 7)))).isEqualTo(6);
    }

    @Test
    void 보너스_번호_유니크한_값을_갖는지_검사() {
        assertThatIllegalArgumentException().isThrownBy(() -> new WinningLotto(numbers(1, 7), 1)).withMessageContaining("보너스 점수에 당첨 번호를 제외한 번호만 입력해주세요.");
    }

    @Test
    void 보너스_맞았는지_확인() {
        WinningLotto winningLotto = new WinningLotto(numbers(1, 7), 7);
        Lotto lotto1 = new Lotto(numbers(1, 7));
        assertThat(winningLotto.matchedBonus(lotto1)).isFalse();

        Lotto lotto2 = new Lotto(numbers(2, 8));
        assertThat(winningLotto.matchedBonus(lotto2)).isTrue();
    }

    private List<LottoNumber> numbers(int min, int max) {
        return IntStream.range(min, max).boxed().map(v -> LottoNumber.of(v)).collect(Collectors.toList());
    }
}
