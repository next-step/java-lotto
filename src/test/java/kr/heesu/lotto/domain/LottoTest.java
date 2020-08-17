package kr.heesu.lotto.domain;

import javafx.scene.effect.Bloom;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    void match_test() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> answer = new ArrayList<>(Arrays.asList(1, 2, 3, 7, 8, 9));

        Lotto lotto = Lotto.of(numbers);

        assertThat(lotto.match(answer)).isEqualTo(3);
    }
}
