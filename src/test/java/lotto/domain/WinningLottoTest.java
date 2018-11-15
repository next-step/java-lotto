package lotto.domain;

import org.junit.Test;

@SuppressWarnings("NonAsciiCharacters")
public class WinningLottoTest {

    @Test(expected = IllegalArgumentException.class)
    public void 로또번호가_없으면_IllegalArgumentException_예외를_던진다() {
        new WinningLotto(null, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 보너스_번호가_0_일떄_IllegalArgumentException_예외를_던진다() {
        new WinningLotto(new Lotto(), 0);
    }

}
