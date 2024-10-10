package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {
    @Test
    void getMatchCnt() {
        List<Integer> targetNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(targetNumbers);
        assertThat(lotto.getMatchCnt(targetNumbers)).isEqualTo(6);
    }
    @ParameterizedTest
    @NullSource
    @EmptySource
    @DisplayName("비교대상 로또 번호 비어있음")
    void getMatchCnt_targetNubers_empty(List<Integer> test) {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        assertThatThrownBy(()->lotto.getMatchCnt(test))
                .isInstanceOf(RuntimeException.class).
                hasMessage("유효하지 않은 당첨 로또 번호 입니다");
    }
}
