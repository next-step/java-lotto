package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class LottoTest {

    @Test
    public void getLottosFromLottoCount() {
        Lotto lotto = new Lotto();
        assertEquals(6, lotto.getNumbers().size());
    }

}