package lotto.domain.factory;

import lotto.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosFactoryTest {

    private LottoGenerator manualLottoGenerator;
    private LottoGenerator randomLottoGenerator;

    @BeforeEach
    void setup() {
        manualLottoGenerator = new CustomManualLottoGenerator();
        randomLottoGenerator = new CustomRandomLottoGenerator();
    }

    @DisplayName("LottosFactory 수동 로또 생성 테스트")
    @Test
    void case1() {
        List<Lotto> lottoList = LottosFactory.issueLotto(1, manualLottoGenerator);

        assertThat(lottoList.size()).isEqualTo(1);
        assertThat(lottoList.get(0)).isEqualToComparingFieldByField(Lotto.of(manualLottoGenerator));
    }

    @DisplayName("LottosFactory 랜덤 로또 생성 테스트")
    @Test
    void case2() {
        List<Lotto> lottoList = LottosFactory.issueLotto(1, randomLottoGenerator);

        assertThat(lottoList.size()).isEqualTo(1);
        assertThat(lottoList.get(0)).isEqualToComparingFieldByField(Lotto.of(randomLottoGenerator));
    }

    public class CustomManualLottoGenerator extends ManualLottoGenerator {
        @Override
        public String intput() {
            return "11,12,13,14,15,16";
        }
    }

    public class CustomRandomLottoGenerator extends RandomLottoGenerator {
        @Override
        protected Set<LottoNumber> random() {
            //1,2,3,4,5,6
            return IntStream.range(1, 7)
                    .boxed()
                    .map(LottoNumber::of)
                    .collect(Collectors.toSet());
        }
    }
}
