package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    final static Lotto testLotto;

    static {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        testLotto = convertToLotto(numbers);
    }

    @DisplayName("문자열 배열을 입력 받아 Lotto 객체를 반환한다")
    @Test
    void 문자열_배열을_Lotto로_변환() {
        String[] givenNumbers = {"6", "5", "4", "3", "2", "1"};
        Lotto actual = Lotto.from(givenNumbers);

        assertThat(actual.getLottoNumbers()).hasSameElementsAs(testLotto.getLottoNumbers());
    }

    @DisplayName("[6개 미만의 숫자] 로또는 6개의 숫자로 이루어진다")
    @Test
    void 숫자_6개_보다_적은_경우() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        assertThatThrownBy(() -> convertToLotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("[6개 초과의 숫자] 로또는 6개의 숫자로 이루어진다")
    @Test
    void 숫자_6개_보다_많은_경우() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        assertThatThrownBy(() -> convertToLotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("[중복되는 숫자] 로또는 서로 다른 6개의 숫자로 이루어진다")
    @Test
    void 중복되는_숫자가_있는_경우() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 5);

        assertThatThrownBy(() -> convertToLotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("생성된 로또의 숫자를 확인할 수 있다")
    @Test
    void 로또_번호_확인() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = convertToLotto(numbers);

        List<Integer> actual = lotto.getLottoNumbers().stream()
                .map(LottoNumber::get)
                .collect(Collectors.toList());

        assertThat(actual).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    private static Lotto convertToLotto(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = numbers.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList());

        return Lotto.from(lottoNumbers);
    }
}
