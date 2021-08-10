package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {

    @Test
    public void 로또생성기를_통해서_로또를_생성_후_로또가_같은지_확인한다(){
        //given
        LottoGenerator generator = new TestableLottoGenerator();
        //when
        Lotto lotto = generator.generate();
        //then
        assertThat(lotto).isEqualTo(new Lotto(new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9, 11))));
    }

    private static class TestableLottoGenerator extends LottoGenerator {
        @Override
        public Lotto generate() {
            return new Lotto(new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9, 11)));
        }
    }
}
