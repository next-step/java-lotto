package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPaperTest {

    @DisplayName("로또 자동 넘버 테스트")
    @Test
    public void lottoRandomNumberTest() {
        LottoPaper lottoPaper = new LottoPaper(
                new LottoNumberStragey(){
                    @Override
                    public Set<Integer> getLottoNumber() {
                        return new HashSet<>(Arrays.asList(1,2,3,4,5,6));
                    }
                }
        );

        assertThat(lottoPaper.getLottoNumber()).contains(1,2,3,4,5,6);
    }

}