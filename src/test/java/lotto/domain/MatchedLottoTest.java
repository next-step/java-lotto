package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class MatchedLottoTest {

    private LottoNumbers winningNumbers;
    private LottoNumber bonusNumber;

    @BeforeEach
    void setUp(){
        winningNumbers = LottoNumbers.createManualLottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        bonusNumber = new LottoNumber(7);
    }

    @ParameterizedTest(name = "[{index}] 입력값 = {0}, 등수 = {1}")
    @MethodSource("lottoMissData")
    @DisplayName("로또 매치 테스트")
    void matchedLottoTest(List<Integer> lottoNumbers, CalculatePrize resultPrize) {
        LottoNumbers myLottoNumbers = LottoNumbers.createManualLottoNumber(lottoNumbers);
        MatchedLotto matchedLotto = new MatchedLotto(winningNumbers, bonusNumber,myLottoNumbers);
        CalculatePrize calculatePrize = matchedLotto.matchingPrize();
        assertThat(calculatePrize).isEqualTo(resultPrize);
    }

    static Stream<Arguments> lottoMissData() {
        return Stream.of(
            Arguments.of(Arrays.asList(10, 11, 12, 13, 14, 15), CalculatePrize.MISS),
            Arguments.of(Arrays.asList(1, 11, 12, 13, 14, 15), CalculatePrize.MISS),
            Arguments.of(Arrays.asList(1, 2, 12, 13, 14, 15), CalculatePrize.MISS),
            Arguments.of(Arrays.asList(1, 2, 3, 13, 14, 15), CalculatePrize.FIFTH),
            Arguments.of(Arrays.asList(1, 2, 3, 4, 14, 15), CalculatePrize.FOURTH),
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 15), CalculatePrize.THIRD),
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 7), CalculatePrize.SECOND),
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), CalculatePrize.FIRST)
        );
    }
}