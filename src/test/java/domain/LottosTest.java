package domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void 로또가_갯수만큼_생기는지_확인(int count) {
        assertThat(new Lottos(new LottoGenerator(), count).size()).isEqualTo(count);
    }

    @Test
    void 로또가_3개_맞은_경우() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,7,8,9));
        assertThat(new Lottos(new LottoGenerator(1,6),1).calculateNumbers(lotto,3));
    }

    @Test
    void 로또가_4개_맞은_경우() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,7,8));
        assertThat(new Lottos(new LottoGenerator(1,6),1).calculateNumbers(lotto,4));
    }

    @Test
    void 로또가_5개_맞은_경우() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,7));
        assertThat(new Lottos(new LottoGenerator(1,6),1).calculateNumbers(lotto,5));
    }

    @Test
    void 로또가_6개_맞은_경우() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        assertThat(new Lottos(new LottoGenerator(1,6),1).calculateNumbers(lotto,6));
    }

}