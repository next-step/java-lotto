package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    void getMatchedNumberCount() {
        Integer[] lottoNumbers = new Integer[] {1,2,3,4,5,6};
        Lotto lotto = new Lotto(lottoNumbers);
        int matchedNumberCount = lotto.getMatchedNumberCount(new Integer[]{1, 2, 3, 4, 5, 6});

        assertThat(matchedNumberCount).isEqualTo(6);
    }

}