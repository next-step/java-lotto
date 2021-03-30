package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.Domain.Money;
import step2.Domain.RandomLottoNumberGenerator;

import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberGeneratorTest {

    @Test
    @DisplayName("로또 번호 6개 생성 테스트")
    void six_lottos() {
        RandomLottoNumberGenerator randomGenerator = new RandomLottoNumberGenerator(new Money(1000));
        assertThat(randomGenerator.generate().get(0).getLottoNumberList()
                .stream()
                .collect(Collectors.toSet())).hasSize(6);
    }

}
