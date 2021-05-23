package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoGeneratorTest {

    @Test
    void 로또넘버_생성테스트(){
        List<LottoNumber> numberList = Arrays.asList(new LottoNumber(1), new LottoNumber(1), new LottoNumber(1), new LottoNumber(1), new LottoNumber(1), new LottoNumber(1));
        LottoNumbers expected = new LottoNumbers(numberList);
        LottoGenerator lottoGenerator = new LottoGenerator(new MockGenerateRule());
        LottoNumbers actual = lottoGenerator.generate();
        assertThat(actual).isEqualTo(expected);
    }
}