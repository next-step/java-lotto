package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LottoTest {


    @DisplayName("로또 번호 저장 테스")
    @Test
    void 로또_번호_저장() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        Lotto lotto = new Lotto(numbers);
        Assertions.assertThat(lotto.getNumbers()).isEqualTo(numbers);
    }

}