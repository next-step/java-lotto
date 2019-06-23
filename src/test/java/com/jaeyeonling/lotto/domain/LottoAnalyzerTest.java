package com.jaeyeonling.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoAnalyzerTest {

    @DisplayName("로또 정보를 분석 후 당첨 횟수 확인")
    @ParameterizedTest
    @ValueSource(ints = {
            1,
            4,
            5
    })
    void should_return_matchCountOnReport_by_lottoAnalyzer(final int analyzeCount) {
        // given
        final LottoGameReport report = generateLottoGameReport(analyzeCount);

        // when
        final int matchCount = report.getMatchCountByPrize(LottoPrize.JACKPOT);

        // then
        assertThat(matchCount).isEqualTo(analyzeCount);
    }

    @DisplayName("로또 정보를 분석 후 당첨 금액 확인")
    @ParameterizedTest
    @ValueSource(ints = {
            1,
            4,
            5
    })
    void should_return_totalPrizeMoneyOnReport_by_lottoAnalyzer(final int analyzeCount) {
        // given
        final LottoGameReport report = generateLottoGameReport(analyzeCount);

        // when
        final Money totalPrizeMoney = report.getTotalPrizeMoney();
        final Money expect = new Money(LottoPrize.JACKPOT.getPrizeMoney() * analyzeCount);

        // then
        assertThat(totalPrizeMoney).isEqualTo(expect);
    }

    @DisplayName("로또 정보를 분석 후 수익률 확인")
    @ParameterizedTest
    @ValueSource(ints = {
            1,
            2,
            5
    })
    void should_return_returnOnInvestment_by_lottoAnalyzer(final int analyzeCount) {
        // given
        final LottoGameReport report = generateLottoGameReport(analyzeCount);
        final int totalBuyingMoney = analyzeCount * Lotto.PRICE_VALUE;

        // when
        final double returnOnInvestment = report.getReturnOnInvestment();
        final double expect = LottoPrize.JACKPOT.getPrizeMoney() * analyzeCount / totalBuyingMoney;

        // then
        assertThat(returnOnInvestment).isEqualTo(expect);
    }

    @DisplayName("로또 2등 당첨 테스트 ")
    @Test
    void should_return_second() {
        // given
        final Lotto winningLotto = new FixtureLotto();
        final Lotto expectLotto = new FixtureLotto(LottoNumber.MIN + 1);

        final LottoNumber bonusLottoNumber = new LottoNumber(Lotto.COUNT_OF_LOTTO_NUMBER + 1);

        // when
        final LottoAnalyzer analyzer = new LottoAnalyzer(winningLotto, bonusLottoNumber);
        final LottoGameReport report = analyzer.analyze(List.of(expectLotto));

        // then
        assertThat(report.getMatchCountByPrize(LottoPrize.SECOND)).isEqualTo(1);
    }

    private LottoGameReport generateLottoGameReport(final int analyzeCount) {
        final Lotto lotto = new FixtureLotto();
        final LottoAnalyzer lottoAnalyzer = new LottoAnalyzer(lotto, new LottoNumber(LottoNumber.MAX));

        return lottoAnalyzer.analyze(generateLottos(analyzeCount, lotto));
    }

    private List<Lotto> generateLottos(final int analyzeCount, final Lotto lotto) {
        final List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < analyzeCount; i++) {
            lottos.add(lotto);
        }

        return lottos;
    }
}
