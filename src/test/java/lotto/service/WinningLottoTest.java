package lotto.service;

import exception.CustomException;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumberRange;
import lotto.domain.StringLottoNumbers;
import lotto.domain.enums.MatchNumberAndPrize;
import lotto.exception.LottoErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {

    private final LottoNumber testBonusNumber = LottoNumber.from(10);
    private final Lotto lotto = LottoNumberRange.createLotto();

    @Test
    @DisplayName("당첨 번호를 통해 로또 통계 서비스를 생성한다")
    void createLottoStatisticalService() {
        WinningLotto winningLotto =
                new WinningLotto(lotto, testBonusNumber);
        assertThat(winningLotto).isNotNull();
    }

    @Test
    @DisplayName("2등 당첨 테스트")
    void secondBonus() {
        final Lotto lotto =
                StringLottoNumbers.toLotto("1, 2, 3, 4, 5, 6");
        List<Lotto> purchasedLotto = List.of(lotto);

        final Lotto winningLotto = StringLottoNumbers.toLotto("1, 2, 3, 4, 5, 7");
        final LottoNumber bonusNumber = LottoNumber.from(6);

        WinningLotto winningLottoService =
                new WinningLotto(winningLotto, bonusNumber);

        Map<MatchNumberAndPrize, Integer> matchNumberAndPrizeIntegerMap =
                winningLottoService.giveStatistics(purchasedLotto);

        assertThat(matchNumberAndPrizeIntegerMap.get(MatchNumberAndPrize.SECOND)).isOne();

    }

    @Test
    @DisplayName("중복된 글자가 포함 시 당첨 번호가 생성되지 않는다")
    void createLottoStatisticalServiceFail() {
        assertThatThrownBy(() ->
                new WinningLotto(StringLottoNumbers.toLotto("1, 2, 2, 3, 4, 5"),
                        testBonusNumber))
                .isInstanceOf(CustomException.class)
                .hasMessage(LottoErrorCode.LOTTO_NUMBER_OVERLAP.getMessage());
    }

    @Test
    @DisplayName("당첨 로또와 구매한 로또를 비교해 당첨 통계 결과값을 반환한다")
    void giveStatistics() {
        List<Lotto> purchasedLotto = new ArrayList<>();
        Lotto winningLotto = LottoNumberRange.createLotto();
        purchasedLotto.add(winningLotto);

        WinningLotto lottoStatisticalService = new WinningLotto(winningLotto, testBonusNumber);
        Map<MatchNumberAndPrize, Integer> matchNumberAndPrizeIntegerMap =
                lottoStatisticalService.giveStatistics(purchasedLotto);

        Integer result = matchNumberAndPrizeIntegerMap.get(MatchNumberAndPrize.FIRST);

        assertThat(result).isOne();
    }
}