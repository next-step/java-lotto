package autoLotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LottosTest {

    @Test
    void lotto() {
        Lottos lottos = new Lottos();
        lottos.addLotto(new Lotto());
    }

    @Test
    void test() {
        String[] str = {"hello", "hi"};
        System.out.println(Arrays.toString(str));
    }
}
