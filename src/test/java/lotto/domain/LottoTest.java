package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoTest {

    private Lotto answerLottoNumber;

    @BeforeEach
    void setUp() {
        answerLottoNumber = new Lotto(Arrays.asList(1,2,3,4,5,6));
    }

    @ParameterizedTest
    @DisplayName("로또 번호는 6개여야 한다.")
    @ValueSource(ints = {5,7})
    void checkLottoNumbersSizeTest(int size) {
        List<Integer> inputList = IntStream.range(0, size)
                .boxed()
                .collect(Collectors.toList());

        assertThatThrownBy(() -> new Lotto(inputList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("6개의 숫자");
    }

    @Test
    @DisplayName("로또 번호는 중복되지 않은 6개의 숫자가 아니면 실패한다.")
    void checkLottoNumbersSizeTest() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1,1,2,3,4,5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("6개의 숫자");
    }

    @Test
    @DisplayName("6개의 로또번호가 같으면 동등한 객체다.")
    void comparePickedLottoTest() {
        Lotto selectLotto = new Lotto(Arrays.asList(6,5,4,3,2,1));

        assertThat(answerLottoNumber).isEqualTo(selectLotto);
    }

    @Test
    @DisplayName("로또 번호 간 비교해서 전부 맞는지 반환된다.")
    void compareTest_allMatched() {
        Lotto secondLotto = new Lotto(Arrays.asList(6,5,4,3,2,1));

        assertThat(answerLottoNumber.compare(secondLotto)).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 번호 간 비교해서 전부 틀린지 반환된다.")
    void compareTest_notMatched() {
        Lotto secondLotto = new Lotto(Arrays.asList(7,8,9,10,11,12));

        assertThat(answerLottoNumber.compare(secondLotto)).isEqualTo(0);
    }
}
