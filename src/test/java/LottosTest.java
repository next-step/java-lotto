import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottosTest {


    @Test
    void test1() {
        Lottos lottos = new Lottos(14000);
        Assertions.assertThat(lottos.size()).isEqualTo(14);
    }
}
