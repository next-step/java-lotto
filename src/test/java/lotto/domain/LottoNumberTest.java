package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {
    @Test
    public void create(){
        LottoNumber lottoNumber = new LottoNumber();
        System.out.println(lottoNumber.toString());
//        assertThat(lottoNumber.getLottoNumber().length()).isEqualTo(5);
    }
}
