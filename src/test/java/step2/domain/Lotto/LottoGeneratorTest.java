package step2.domain.Lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.strategy.LottoShuffleStrategy;

import java.util.Collections;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {

    @DisplayName("LottoNumbersGenerator 인스턴스 생성 테스트")
    @Test
    void 생성() {
        // when
        LottoGenerator lottoGenerator = LottoGenerator.getInstance();

        // then
        assertThat(lottoGenerator).isNotNull();
    }

    @DisplayName("LottoNumbersGenerator 인스턴스가 Lotto 인스턴스를 생성하고 반환하는지 테스트")
    @Test
    void 반환_Lotto() {
        // given
        LottoGenerator lottoGenerator = LottoGenerator.getInstance();

        // when
        Lotto lotto = lottoGenerator.generateLotto();

        // then
        assertThat(lotto).isNotNull();
    }

    @DisplayName("LottoNumbersGenerator 인스턴스가 LottoShuffleStrategy 대로 셔플을 진행하는지 테스트")
    @Test
    void 반환_Lotto_셔플() {
        // given
        LottoShuffleStrategy lottoShuffleStrategy = lottoNumbers -> {
            Collections.sort(lottoNumbers);
        };

        LottoGenerator lottoGenerator = LottoGenerator.getInstance(lottoShuffleStrategy);

        // when
        Lotto lotto = lottoGenerator.generateLotto();

        // then
        //assertThat(lotto).isEqualTo();
    }

}