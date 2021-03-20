package domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.ThreadLocalRandom;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    public void test(){
        Lotto lotto = new Lotto();
        System.out.println(lotto.getNumbers());
        System.out.println();
    }
}
