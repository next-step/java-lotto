package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTest {

    @Test
    @DisplayName("로또 번호는 매번 다르게 생성됨")
    public void 로또_번호_랜덤_생성() {
        Lotto lotto = new Lotto();
        Lotto lotto1 = new Lotto();
        Assertions.assertThat(lotto)
                .isNotEqualTo(lotto1);
    }

    @Test
    @DisplayName("로또 번호는 6개로 구성됨")
    public void 로또_번호_6개() {
        Assertions.assertThat(new Lotto().numbers().size())
                .isEqualTo(6);
    }

    @Test
    @DisplayName("로또 번호는 정렬되어 있음")
    public void 로또_번호_정렬() {
        List<Integer> numbers = new Lotto().numbers();
        List<Integer> beforeNumbers = new ArrayList<>(numbers);
        Collections.sort(numbers);
        Assertions.assertThat(numbers)
                .isEqualTo(beforeNumbers);
    }
}
