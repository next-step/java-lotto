package lotto.generator;

import lotto.domain.Lottos;
import lotto.domain.Money;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoBundleGeneratorTest {

    @Test
    void generate() {
        Money money = new Money(5_000);
        List<String> values = List.of(
                "1,2,3,4,5,6",
                "2,3,4,5,6,7",
                "3,4,5,6,7,8"
        );
        LottoBundleGenerator lottoBundleGenerator = new LottoBundleGenerator(money, values);
        Lottos lottos = lottoBundleGenerator.generate();
        assertThat(lottos.size()).isEqualTo(money.getLottoTicketCount());
        System.out.println(lottos);
    }
}