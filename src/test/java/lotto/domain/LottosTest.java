package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    private LottoGenerator lottoGenerator;

    @BeforeEach
    void setup() {
        lottoGenerator = new TesterLottoGenerator();
    }

    @DisplayName("Lottos 생성 테스트")
    @Test
    void of() {
        List<Lotto> lottos = Arrays.asList(Lotto.of(lottoGenerator), Lotto.of(lottoGenerator));

        assertThat(new Lottos(lottos))
                .isEqualToComparingFieldByField(new Lottos(lottos));
    }

    @DisplayName("getLottos() 메소드 호출시 취약점 방어 테스트")
    @Test
    void get() {
        Lotto lotto = Lotto.of(lottoGenerator);

        List<Lotto> lottos = Arrays.asList(Lotto.of(lottoGenerator));

        List<Lotto> lottosList = (new Lottos(lottos)).getLottos();

        Lotto modifyLotto = Lotto.of(new StupLottoGenerator());
        lottos.set(0, modifyLotto);

        assertThat(lottosList.get(0)).isEqualToComparingFieldByField(lotto);
    }

    class StupLottoGenerator implements LottoGenerator {

        @Override
        public Set<Integer> create() {
            // 11,12,13,14,15,16
            return IntStream.range(11, 17)
                    .boxed()
                    .collect(Collectors.toSet());
        }
    }
}