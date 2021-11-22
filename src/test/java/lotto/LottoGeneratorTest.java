package lotto;

import lotto.strategy.LotteryStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoGeneratorTest {

    private final LotteryStrategy lotteryStrategy = numbers -> numbers.selectNumbers(6);

    @Test
    @DisplayName("generateLottoNumber 로또 번호 목록을 생성한다")
    void 테스트_generateLottoNumber_로또_번호_목록_반환() {
        // given
        LottoGenerator generator = new LottoGenerator(lotteryStrategy);

        // when
        LottoNumbers lottoNumbers = generator.generateLottoNumber();

        // then
        // then
        assertThat(lottoNumbers).isEqualTo(new LottoNumbers(
                Arrays.asList(new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6))));
    }
}