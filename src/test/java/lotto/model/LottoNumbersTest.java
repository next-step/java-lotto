package lotto.model;


import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersTest {

    @Test
    public void 랜덤_번호_가져오기() {
        List<Integer> randomNumber = LottoNumbers.getAutoNumbers();

        assertThat(randomNumber.size()).isEqualTo(6);
    }
}