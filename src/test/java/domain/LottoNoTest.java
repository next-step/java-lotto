package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNoTest {
    @Test
    void equalsTest(){
        LottoNo lottoNo1 = new LottoNo(4);
        LottoNo lottoNo2 = new LottoNo(4);

        assertThat(lottoNo1.equals(lottoNo2)).isEqualTo(true);
    }

}
