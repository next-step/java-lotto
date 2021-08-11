package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketGeneratorTest {

    @Test
    public void 로또생성기를_통해서_로또를_생성_후_로또가_같은지_확인한다(){
        //given
        LottoGenerator generator = new TestableLottoGenerator();
        //when
        LottoTicket lottoTicket = generator.generate();
        //then

        assertThat(lottoTicket).isEqualTo(new LottoTicket(Arrays.asList(new LottoNumber(1), new LottoNumber(3),
                new LottoNumber(5), new LottoNumber(7), new LottoNumber(9),
                new LottoNumber(11))));
    }

    private static class TestableLottoGenerator extends LottoGenerator {
        @Override
        public LottoTicket generate() {
            return new LottoTicket(new ArrayList<>(Arrays.asList(new LottoNumber(1), new LottoNumber(3),
                    new LottoNumber(5), new LottoNumber(7), new LottoNumber(9),
                    new LottoNumber(11))));
        }
    }
}
