package study.step4.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step3.domain.LottoNumber;
import study.step3.domain.LottoNumbers;
import study.step3.domain.LottoWinners;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("당첨 번호 세팅")
class LottoWinnersTest {

    private Set<Integer> lottoNumber;

    @BeforeEach
    public void setUp() {
        lottoNumber = IntStream.range(1,7)
                .boxed()
                .collect(Collectors.toSet());
    }

    @Test
    @DisplayName("당첨번호와 보너스번호 중복 테스트")
    void 당첨번호와_보너스번호_중복_테스트() {
        study.step3.domain.LottoNumbers winner = new LottoNumbers(lottoNumber);
        study.step3.domain.LottoNumber bonus = new LottoNumber(1);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoWinners(winner, bonus);
        });
    }
}