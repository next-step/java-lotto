package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoNumbersTest {

    @Test
    @DisplayName("선택된 6개의 로또번호 같은지 Test")
    void comparePickedLottoTest() {
        // given
        List<Integer> firstPickedLotto = Arrays.asList(1,2,3,4,5,6);
        List<Integer> secondPickedLotto = Arrays.asList(6,5,4,3,2,1);

        // when
        LottoNumbers firstLotto = new LottoNumbers(firstPickedLotto);
        LottoNumbers secondLotto = new LottoNumbers(secondPickedLotto);

        assertThat(firstLotto).isEqualTo(secondLotto);
    }
}
