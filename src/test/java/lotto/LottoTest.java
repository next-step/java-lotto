package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    private Lotto lotto;
    private List<Integer> numberSetList = new ArrayList<>();
    private Lotto setNumberLotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto();

        numberSetList.add(1);
        numberSetList.add(3);
        numberSetList.add(5);
        numberSetList.add(7);
        numberSetList.add(9);

        setNumberLotto = new Lotto(numberSetList);
    }

    @Test
    void lottoInitTest() {
        assertThat(lotto.getClass().getSimpleName()).isEqualTo("Lotto");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9})
    void lottoNumberSetTest(int number) {
        assertThat(setNumberLotto.isContainsNumber(number)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 11, 12, 13})
    void lottoNumberSetFailTest(int number) {
        assertThat(setNumberLotto.isContainsNumber(number)).isFalse();
    }
}
