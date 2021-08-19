package lotto.domain;

import lotto.exception.BonusNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {

    private List<LottoNumber> lottoNumbers = new ArrayList<>(Arrays.asList(new LottoNumber(1),
                    new LottoNumber(2),
                    new LottoNumber(3),
                    new LottoNumber(4),
                    new LottoNumber(5),
                    new LottoNumber(6)));

    private Lotto winningLotto = new Lotto(lottoNumbers);

    static Stream<Arguments> winningLottoSource() {
        return Stream.of(
                Arguments.of(new LottoNumber(1))
                ,Arguments.of(new LottoNumber(2))
                ,Arguments.of(new LottoNumber(3))
        );
    }

    @ParameterizedTest
    @DisplayName("보너스 숫자 예외 테스트")
    @MethodSource("winningLottoSource")
    void bonusException(LottoNumber bonusNumber) {
        assertThrows(BonusNumberException.class, () -> new WinningLotto(winningLotto, bonusNumber));
    }
}