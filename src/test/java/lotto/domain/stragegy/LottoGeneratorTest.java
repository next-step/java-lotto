package lotto.domain.stragegy;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {

    @Test
    public void makeLottoNumber() throws Exception {
        //when
        List<Integer> integers = LottoGenerator.lottoNumberGenerator();

        //then
        assertThat(integers.size()).isEqualTo(6);
    }
}
