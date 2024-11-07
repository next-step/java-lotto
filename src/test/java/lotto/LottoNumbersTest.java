package lotto;

import lotto.domain.WinningLotto;
import org.junit.jupiter.api.Test;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumbersTest {

    @ParameterizedTest
    @MethodSource(value = "lottoProvider")
    public void 당첨번호_일치개수별_랭크테스트_보너스볼포함(int startNumber, int endNumber, int bonusNumber, LottoRank lottoRank) {
        LottoNumber bonusBall = new LottoNumber(bonusNumber);
        List<LottoNumber> winnerNumberList = IntStream.rangeClosed(1, 6)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());

        LottoNumbers lottonumbers = new LottoNumbers(IntStream.range(startNumber, endNumber)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList()));
        LottoNumbers lottoWinningNumbers = new LottoNumbers(winnerNumberList);
        assertThat(new WinningLotto(lottoWinningNumbers, bonusBall).lottoRank(lottonumbers)).isEqualTo(lottoRank);
    }

    @Test
    public void 개수_6개_불일치_테스트() {
        final List<LottoNumber> testNumberList = IntStream.range(1, 6)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoNumbers lottoWinningNumbers = new LottoNumbers(testNumberList);
        });
    }

    static Stream<Object> lottoProvider() {
        return Stream.of(
                Arguments.of(3,9,10,LottoRank.FOURTH),
                Arguments.of(2,8,10,LottoRank.THIRD),
                Arguments.of(2,8,1,LottoRank.SECOND),
                Arguments.of(1,7,7,LottoRank.FIRST)
                );
    }


}
