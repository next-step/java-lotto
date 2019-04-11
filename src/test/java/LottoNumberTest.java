import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LottoNumberTest {

    @Test(expected = IllegalArgumentException.class)
    public void 사십오_이상_숫자_에러발생() {
        new LottoNumber("46");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 일_이하_숫자_에러발생() {
        new LottoNumber("0");
    }

    @Test
    public void 숫자같은_경우_같다() {
        assertEquals(new LottoNumber(5), new LottoNumber(5));
    }
}