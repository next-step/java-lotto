package domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class LottoNoTest {

    @Test(expected = IllegalArgumentException.class)
    public void 로또_범위_초과() {
        new LottoNo(48);
    }

    @Test
    public void 로또_생성() {
        new LottoNo(11);
    }
}
