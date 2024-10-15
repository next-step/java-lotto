package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGeneratorTest {
    @Test
    @DisplayName("로또 생성 테스트")
    void 로또_생성_테스트() {
        Lottos lottos = new Lottos();
        lottos.buyLotto(3000, () -> new Lotto(IntStream.rangeClosed(1, 6)
                .boxed()
                .map(LottoNumber::createLottoNumber)
                .collect(Collectors.toList())));

        Assertions.assertThat(lottos.getNumberOfLotto()).isEqualTo(3);
    }
}
