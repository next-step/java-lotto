package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {
    private List<LottoNumber> numbers(int min, int max) {
        return IntStream.range(min, max).boxed().map(v -> new LottoNumber(v)).collect(Collectors.toList());
    }

    @Test
    void 생성() {
        assertThat(new Lotto(numbers(1, 7))).isEqualTo(new Lotto(numbers(1, 7)));
    }

    @Test
    void 유니크한_랜덤_번호로_생성() {
        assertThat(new Lotto().getSortedNumbers()).doesNotHaveDuplicates();
    }

    @Test
    void 교집합으로_숫자_추리기() {
        assertThat(new Lotto(numbers(1, 7)).correctCount(new Lotto(numbers(1, 7)))).isEqualTo(6);
    }

    @Test
    void 모든_번호가_유니크한_값을_갖는지_검사() {
        List<LottoNumber> notUniqueNumbers = List.of(new LottoNumber(1), new LottoNumber(1), new LottoNumber(1), new LottoNumber(1), new LottoNumber(1), new LottoNumber(1));
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(notUniqueNumbers)).withMessageContaining("유니크한 값으로만 구성해야합니다.");
    }

    @Test
    void 보너스_맞았는지_확인() {
        Lotto winningLotto = new Lotto(numbers(1, 7), 7);
        Lotto lotto1 = new Lotto(numbers(1, 7));
        assertThat(winningLotto.matchedBonus(lotto1)).isFalse();

        Lotto lotto2 = new Lotto(numbers(2, 8));
        assertThat(winningLotto.matchedBonus(lotto2)).isTrue();
    }

    @Test
    void 보너스_번호_유니크한_값을_갖는지_검사() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(numbers(1, 7), 1)).withMessageContaining("보너스 점수에 당청 번호를 제외한 번호만 입력해주세요.");
    }
}
