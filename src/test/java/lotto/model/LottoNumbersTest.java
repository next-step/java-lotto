package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumbersTest {

    @Test
    void 객체생성_테스트(){
        LottoNumbers actual = new LottoNumbers(Arrays.asList(new LottoNumber(1), new LottoNumber(2)));
        assertThat(actual.contains(new LottoNumber(1))).isTrue();
        assertThat(actual.contains(new LottoNumber(2))).isTrue();
        assertThat(actual.contains(new LottoNumber(3))).isFalse();
    }

    @Test
    void 정렬_테스트(){
        LottoNumbers actual = new LottoNumbers(Arrays.asList(new LottoNumber(3), new LottoNumber(1), new LottoNumber(2))).sort();
        LottoNumbers expected = new LottoNumbers(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3)));

        assertThat(actual).isEqualTo(expected);
    }
}