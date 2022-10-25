package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningTest {

    private final List<List<Integer>> list = new ArrayList<>();
    private final LottoCollection collection = new LottoCollection(list);

    @ParameterizedTest
    @ValueSource(strings = {"46", "-1", "0", "", " ", "!", "!@#abc", "가"})
    @DisplayName("로또번호는 1과 45 사이값이어야만 한다")
    void winningNumberBoundTest(String input) {
        assertThatThrownBy(() -> {
            new Winning(collection, new String[]{input, "2", "3", "4", "5", "6"});
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또번호는 6개를 입력해야한다")
    void winningNumberQuantityTest() {
        assertThatThrownBy(() -> {
            new Winning(collection, new String[]{"2", "3", "4", "5", "6"});
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
