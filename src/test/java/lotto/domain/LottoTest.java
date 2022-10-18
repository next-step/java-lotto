package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    @DisplayName("로또 번호 중복 확인")
    void getNumberList() {

        // given
        Lotto lotto = new Lotto();
        List<Integer> numberList = lotto.getNumberList();

        // expected
        assertThat(numberList).isEqualTo(numberList.stream().distinct().collect(Collectors.toList()));
    }
}
