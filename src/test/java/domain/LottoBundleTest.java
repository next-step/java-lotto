package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoBundleTest {
    @Test
    void 당첨번호가_null이면_예외() {
        assertThatThrownBy(() -> new LottoBundle(new ArrayList<>(), null, new BonusNumber(7)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("winningNums는 null이거나 비어있을 수 없습니다.");
    }

    @Test
    void 당첨번호가_빈_리스트이면_예외() {
        assertThatThrownBy(() -> new LottoBundle(new ArrayList<>(), Collections.emptyList(), new BonusNumber(7)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("winningNums는 null이거나 비어있을 수 없습니다.");
    }

    @Test
    void 당첨번호가_6개가_아니면_예외() {
        assertThatThrownBy(() -> new LottoBundle(new ArrayList<>(), Arrays.asList(1, 2, 3, 4, 5), new BonusNumber(7)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("winningNums의 사이즈가 잘못되었습니다.");
    }
}
