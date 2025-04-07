import Lotto.domain.LottoNumber;
import Lotto.domain.Lotto;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    @Test
    void should_throw_exception_when_lotto_size_is_not_six() {
        List<LottoNumber> invalidNumbers = Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5) // 5개 (부족함)
        );

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Lotto(invalidNumbers)
        );

        assertEquals("로또 번호는 반드시 6개여야 합니다.", exception.getMessage());
    }

    @Test
    void generateLottoNumbers_ShouldReturnSixUniqueNumbers() {
        List<LottoNumber> generatedNumbers = Lotto.generateLottoNumbers();
        assertEquals(6, generatedNumbers.size());
        assertTrue(generatedNumbers.stream().allMatch(n -> n.getNumber() >= 1 && n.getNumber() <= 45));
        assertEquals(generatedNumbers.size(), new HashSet<>(generatedNumbers).size());
    }

    @Test
    void should_throw_exception_when_lotto_contains_duplicate_numbers() {
        List<LottoNumber> invalidNumbers = Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(5) // 중복 있음
        );

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Lotto(invalidNumbers)
        );

        assertEquals("로또 번호는 중복될 수 없습니다.", exception.getMessage());
    }

    @Test
    void should_return_unmodifiable_list_of_lotto_numbers() {
        List<LottoNumber> numbers = Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
        );

        Lotto lotto = new Lotto(numbers);
        List<LottoNumber> lottoNumbers = lotto.getLottoNumbers();

        assertEquals(6, lottoNumbers.size());
        assertThrows(UnsupportedOperationException.class, () -> lottoNumbers.add(new LottoNumber(7)));
    }

    @Test
    void should_return_correct_match_count_with_winning_numbers() {
        List<LottoNumber> numbers = Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
        );

        Lotto lotto = new Lotto(numbers);

        Set<LottoNumber> winningNumbers = new HashSet<>(Arrays.asList(
                new LottoNumber(3), new LottoNumber(4), new LottoNumber(5),
                new LottoNumber(6), new LottoNumber(7), new LottoNumber(8)
        ));

        int matchCount = lotto.countMatches(winningNumbers);
        assertEquals(4, matchCount, "당첨 번호와 일치하는 개수를 올바르게 계산해야 합니다.");
    }
}
