package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberMatcherTest {

    @Test
    void 테스트(){
        LottoNumbers winningNumbers = new LottoNumbers(Arrays.asList(new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));

        LottoNumbers userNumbers = new LottoNumbers(Arrays.asList(new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(4), new LottoNumber(30), new LottoNumber(31)));


        NumberMatcher numberMatcher = new NumberMatcher(winningNumbers);
        int actual = numberMatcher.howManyMatched(userNumbers);
        assertThat(actual).isEqualTo(4);
    }
}
