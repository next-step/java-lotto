package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoTest {

    @Test
    @DisplayName("Set 생성자 테스트")
    public void LottoSetParameterConstructorTest() {
        Set<List<Integer>> expect = generateLottoValue();
        Lotto lotto = new Lotto(expect);

        assertThat(lotto.size()).isEqualTo(expect.size());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 5})
    @DisplayName("주어진 갯수만큼 로또 생성 테스트")
    public void lottoGenerateTest(int input) {
        Lotto lotto = new Lotto(input);

        assertThat(lotto.size()).isEqualTo(input);
    }

    @Test
    @DisplayName("로또 값을 정상적으로 string 변환하는지 테스트")
    public void LottoToStringTest() {
        List<String> toStringExpect = Arrays.asList("[1, 2, 3, 4, 5, 6]","[2, 3, 4, 5, 6, 7]","[3, 4, 5, 6, 7, 8]");

        Lotto lotto = new Lotto(generateLottoValue());

        for (String expect : toStringExpect) {
            assertTrue(lotto.toString("[%s]\n", ", ").contains(expect));
        }
    }

    private Set<List<Integer>> generateLottoValue() {
        Set<List<Integer>> lottoNumbers = new HashSet<>();

        lottoNumbers.add(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoNumbers.add(Arrays.asList(2, 3, 4, 5, 6, 7));
        lottoNumbers.add(Arrays.asList(3, 4, 5, 6, 7, 8));

        return lottoNumbers;
    }
}
