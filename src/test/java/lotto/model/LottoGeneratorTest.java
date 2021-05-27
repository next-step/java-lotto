package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {

    @Test
    void 로또넘버_생성테스트(){
        List<LottoNumber> numberList = Arrays.asList(new LottoNumber(1), new LottoNumber(1), new LottoNumber(1), new LottoNumber(1), new LottoNumber(1), new LottoNumber(1));
        LottoTicket expected = new LottoTicket(numberList);
        LottoGenerator lottoGenerator = new LottoGenerator(new MockGenerateRule());
        LottoTicket actual = lottoGenerator.generate();
        assertThat(actual).isEqualTo(expected);
    }
}