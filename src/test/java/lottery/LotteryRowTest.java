package lottery;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LotteryRowTest {
    @Test
    public void hasGivenNumbers() {
        var numbers = Set.of(1, 2, 3, 4, 5, 6);

        var row = LotteryRow.fromGiven(numbers);

        assertThat(row.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    public void throwErrorWhenSizeIsNot6() {
        assertThatThrownBy(() -> {
            var numbers = Set.of(1, 2, 3, 4, 5);
            LotteryRow.fromGiven(numbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void getsMatchCount() {
        var row1 = LotteryRow.fromGiven(Set.of(1, 2, 3, 4, 5, 6));
        var row2 = LotteryRow.fromGiven(Set.of(4, 5, 6, 7, 8, 9));

        var result = row1.getMatchCount(row2);

        assertThat(result.value()).isEqualTo(3);
    }

    @Test
    public void numbersAreOrdered() {
        var numbers = Set.of(6, 5, 4, 3, 2, 1);

        var row = LotteryRow.fromGiven(numbers);

        assertThat(row.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }
}
