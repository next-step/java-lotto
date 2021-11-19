package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lotto.domain.Lotto;

import static org.assertj.core.api.Assertions.*;
import static lotto.domain.Lotto.SIZE;

import java.util.Arrays;
import java.util.List;

public class LottoTest {
    @Test
    @DisplayName("print 로 랜덤 값이 들어간 배열이 잘 생성되는지 확인")
    void checkMatchingTest() {
        List<Integer> testList = Arrays.asList(1, 2, 3, 4, 5, 6);

        Lotto lotto = new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto.checkMatching(testList)).isEqualTo(6);

        Lotto lotto2 = new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 7));
        assertThat(lotto2.checkMatching(testList)).isEqualTo(5);

        Lotto lotto3 = new Lotto(() -> Arrays.asList(1, 2, 3, 4, 8, 9));
        assertThat(lotto3.checkMatching(testList)).isEqualTo(4);

        Lotto lotto4 = new Lotto(() -> Arrays.asList(7, 8, 9, 4, 5, 6));
        assertThat(lotto4.checkMatching(testList)).isEqualTo(3);

        Lotto lotto5 = new Lotto(() -> Arrays.asList(1, 8, 9, 7, 11, 6));
        assertThat(lotto5.checkMatching(testList)).isEqualTo(2);

        Lotto lotto6 = new Lotto(() -> Arrays.asList(20, 21, 4, 7, 11, 15));
        assertThat(lotto6.checkMatching(testList)).isEqualTo(1);

        Lotto lotto7 = new Lotto(() -> Arrays.asList(20, 21, 43, 7, 11, 15));
        assertThat(lotto7.checkMatching(testList)).isEqualTo(0);
    }

    @Test
    @DisplayName("입력된 lotto 길이가 SIZE 보다 클 때 exception 테스트")
    void sizeCheckTest() {
        assertThatThrownBy(() -> {
            Lotto lotto = new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(SIZE + " 와 길이가 다른 Lotto 는 입력될 수 없습니다.");

        assertThatThrownBy(() -> {
            Lotto lotto = new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5));
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(SIZE + " 와 길이가 다른 Lotto 는 입력될 수 없습니다.");
    }

    @Test
    @DisplayName("입력된 lotto 에 중복된 숫자가 있을 때 exception 테스트")
    void distinctCheckTest() {
        assertThatThrownBy(() -> {
            Lotto lotto = new Lotto(() -> Arrays.asList(1, 2, 3, 4, 6, 6));
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("로또에 중복된 숫자가 존재합니다.");
    }
}
