package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {
    private static final int ROTTO_NUMBER_DIGIT = 6;

    private Lotto lotto;

    @BeforeEach
    public void setUp() {
        this.lotto = new Lotto();
    }

    @DisplayName("로또 숫자 개수는 6자리이며, 중복이 없어야 한다.")
    @Test
    public void testNumberCountsAndIsDistinct() {
        List<Integer> rottoNumbers = lotto.getNumbers();
        Set<Integer> rottoNumbersSet = new HashSet<>(rottoNumbers);

        assertThat(rottoNumbersSet).hasSize(ROTTO_NUMBER_DIGIT);
    }

    @DisplayName("로또 숫자 검색은 반드시 인자 값 만큼 나와야 한다.")
    @ParameterizedTest
    @ValueSource(ints={1,2,3,4,5,6})
    public void testSearchRottoNumbers(int value) {
        List<Integer> rottoNumbers = lotto.getNumbers();
        List<Integer> findNumbers = rottoNumbers.subList(0,value);
        int matchCount = lotto.computeCountOfNumberExist(findNumbers);

        assertThat(matchCount).isEqualTo(value);
    }
}
