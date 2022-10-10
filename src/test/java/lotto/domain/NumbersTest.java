package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class NumbersTest {

    @DisplayName("정렬된 숫자 6개를 뽑는다")
    @Test
    void getSixNumber() {
        List<Integer> sixNumbers = Numbers.getSixNumbers();

        Assertions.assertAll(
                () -> assertThat(sixNumbers.size()).isEqualTo(6),
                () -> assertThat(sixNumbers).isSorted()
        );
    }
}
