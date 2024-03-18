package step2;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    private final Lotto lotto = new Lotto();
    private final List<Integer> lottoNumbers = lotto.getLottoNumbers();

    @Test
    public void 로또_번호는_6개_이다() {
        assertThat(lottoNumbers.size()).isEqualTo(6);
    }

    @Test
    public void 로또_번호는_1에서_45사이의_숫자이다() {
        for (int number : lottoNumbers) {
            assertThat(number > 0 && number < 46).isEqualTo(true);
        }
    }

    @Nested
    class 로또_번호는_중복이_없다 {

        @RepeatedTest(10000)
        public void 로또_번호_중복_테스트() {
            Lotto lottoTest = new Lotto();
            List<Integer> lottoTestNumbers = lottoTest.getLottoNumbers();
            Set <Integer> lottoNumberSet = new HashSet<>(lottoTestNumbers);
            assertThat(lottoNumberSet.size()).isEqualTo(6);
        }
    }
}
