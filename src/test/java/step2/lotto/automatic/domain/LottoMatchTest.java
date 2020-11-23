package step2.lotto.automatic.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoMatchTest {

    private static LottoMatch lottoMatchTest = new LottoMatch(1000);

    @Test
    public void 로또_당첨_번호_NULL_체크() {
        assertThatThrownBy(() ->
                lottoMatchTest.getLottoResult(null)
        ).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void 로또_당첨_번호_EMPTY_체크() {
        assertThatThrownBy(() ->
                lottoMatchTest.getLottoResult("")
        ).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void 로또_당첨_번호_문자_체크() {
        assertThatThrownBy(() ->
                lottoMatchTest.getLottoResult("Dafsadf")
        ).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void 로또_당첨_번호_음수_체크() {
        assertThatThrownBy(() ->
                lottoMatchTest.getLottoResult("-100,1,2,3,4,5")
        ).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void 로또_당첨_번호_범위_체크() {
        assertThatThrownBy(() ->
                lottoMatchTest.getLottoResult("1100,1,2,3,4,5")
        ).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void 로또_당첨_번호_중복테스트() {
        assertThatThrownBy(() ->
                lottoMatchTest.getLottoResult("1,1,2,3,4,5")
        ).isInstanceOf(RuntimeException.class);
    }
}
