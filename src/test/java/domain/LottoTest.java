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

    @Test
    public void calculateLottoMatch() {
        //input: List<Lotto> lottos, Lotto winner
        // output: Map<int, int> -> 3,x 4, x 5, x 6, x

        //TODO
    }
}