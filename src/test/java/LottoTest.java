import lotto.domain.LottoNumber;
import lotto.domain.Lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    @DisplayName("로또 번호가 6개가 아니면 예외가 발생한다")
    @Test
    void should_throw_exception_when_lotto_size_is_not_six() {
        List<LottoNumber> invalidNumbers = Arrays.asList(
                LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                LottoNumber.of(4), LottoNumber.of(5) // 5개 (부족함)
        );

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Lotto(invalidNumbers)
        );

        assertEquals("로또 번호는 반드시 6개여야 합니다.", exception.getMessage());
    }

    @DisplayName("로또 번호 생성 시 중복 없는 6개의 번호가 생성되어야 한다")
    @Test
    void should_generate_six_unique_numbers() {
        List<LottoNumber> generatedNumbers = Lotto.generateLottoNumbers();
        assertEquals(6, generatedNumbers.size());
        assertTrue(generatedNumbers.stream().allMatch(n -> n.getNumber() >= 1 && n.getNumber() <= 45));
        assertEquals(generatedNumbers.size(), new HashSet<>(generatedNumbers).size());
    }

    @DisplayName("로또 번호에 중복이 있으면 예외가 발생한다")
    @Test
    void should_throw_exception_when_lotto_contains_duplicate_numbers() {
        List<LottoNumber> invalidNumbers = Arrays.asList(
                LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(5) // 중복 있음
        );

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Lotto(invalidNumbers)
        );

        assertEquals("로또 번호는 중복될 수 없습니다.", exception.getMessage());
    }

    @DisplayName("로또 번호 리스트는 수정 불가능해야 한다")
    @Test
    void should_return_unmodifiable_list_of_lotto_numbers() {
        List<LottoNumber> numbers = Arrays.asList(
                LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6)
        );

        Lotto lotto = new Lotto(numbers);
        List<LottoNumber> lottoNumbers = lotto.getLottoNumbers();

        assertEquals(6, lottoNumbers.size());
        assertThrows(UnsupportedOperationException.class, () -> lottoNumbers.add(LottoNumber.of(7)));
    }

    @DisplayName("당첨 번호와 일치하는 개수를 정확히 계산해야 한다")
    @Test
    void should_return_correct_match_count_with_winning_numbers() {
        List<LottoNumber> numbers = Arrays.asList(
                LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6)
        );

        Lotto lotto = new Lotto(numbers);

        Set<LottoNumber> winningNumbers = new HashSet<>(Arrays.asList(
                LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5),
                LottoNumber.of(6), LottoNumber.of(7), LottoNumber.of(8)
        ));

        int matchCount = lotto.countMatches(winningNumbers);
        assertEquals(4, matchCount, "당첨 번호와 일치하는 개수를 올바르게 계산해야 합니다.");
    }
}
