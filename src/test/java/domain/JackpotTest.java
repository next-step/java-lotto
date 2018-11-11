package domain;

import org.junit.Before;
import org.junit.Test;

public class JackpotTest {

    private Jackpot jackpot;

    @Before
    public void setup() {
//        jackpot = new Jackpot();
    }

    @Test
    public void 하나_잭팟() {
        System.out.println(Jackpot.valueOf(1));
    }
}
