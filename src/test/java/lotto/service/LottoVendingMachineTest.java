package lotto.service;

import lotto.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoVendingMachineTest {

    private Lottos lottos;

    @BeforeEach
    void setUp() {
        Lotto lotto = new Lotto(Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6))
        );
        this.lottos = new Lottos(Collections.singletonList(lotto));
    }

    @ParameterizedTest
    @ValueSource(strings = "1,2,3,4,5,6")
    @DisplayName("로또번호 6개 일치할시에 결과가 1등인지 테스트")
    void lotto_winning_number (String winningNumber) {
        //given
        List<LottoResult> results = LottoVendingMachine.lottoWinningResults(lottos,winningNumber,7);

        //when
        LottoResult lottoResult = results.get(0);

        //then
        assertThat(lottoResult).isEqualTo(LottoResult.FIRST);
    }

    @ParameterizedTest
    @ValueSource(strings = "1,2,3,4,5,7")
    @DisplayName("로또번호 5개 + 보너스 번호 일치할시에 결과가 2등인지 테스트")
    void lotto_secondWinning_number (String winningNumber) {
        //given
        List<LottoResult> results = LottoVendingMachine.lottoWinningResults(lottos,winningNumber,6);

        //when
        LottoResult lottoResult = results.get(0);

        //then
        assertThat(lottoResult).isEqualTo(LottoResult.SECOND);
    }
}
