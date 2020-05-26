package me.daeho.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("로또 테스트")
class LottoTest {
    @Test
    public void issue_not_6_count_number() {
        List<Integer> fiveNumbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> sevenNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        assertThatThrownBy(() -> Lotto.issue(fiveNumbers))
                .isInstanceOf(RuntimeException.class);

        assertThatThrownBy(() -> Lotto.issue(sevenNumbers))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void containsCountTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> diffNumbers = Arrays.asList(7, 8, 9, 10, 11, 12);

        Lotto lotto = Lotto.issue(numbers);
        assertThat(lotto.containsCount(numbers)).isEqualTo(6);
        assertThat(lotto.containsCount(diffNumbers)).isEqualTo(0);
    }
}