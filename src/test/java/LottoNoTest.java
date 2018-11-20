import domain.LottoNo;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNoTest {
    @Test
    public void 비교() {
        LottoNo lottoNo = LottoNo.from(8);
        LottoNo lottoNo2 = LottoNo.from(8);
        assertThat(lottoNo).isEqualTo(lottoNo2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void 일_보다_작은값() {
        LottoNo lottoNo = LottoNo.from(0);
        assertThat(lottoNo).isEqualTo(LottoNo.from(0));
    }

    @Test (expected = IllegalArgumentException.class)
    public void 사십오_보다_큰값() {
        LottoNo lottoNo = LottoNo.from(46);
        assertThat(lottoNo).isEqualTo(LottoNo.from(46));
    }

    @Test
    public void 인스턴스_재사용() {
        assertThat(LottoNo.from(1) == LottoNo.from(1)).isTrue();
    }
}
