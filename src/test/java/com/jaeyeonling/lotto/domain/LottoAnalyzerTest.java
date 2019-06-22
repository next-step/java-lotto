package com.jaeyeonling.lotto.domain;

import com.jaeyeonling.lotto.config.Env;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

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
        final Set<LottoNumber> lottoNumbers = new HashSet<>();
        for (int lottoNumber = Env.MIN_LOTTO_NUMBER; lottoNumber <= Env.COUNT_OF_LOTTO_NUMBER_IN_LOTTO; lottoNumber++) {
            lottoNumbers.add(new LottoNumber(lottoNumber));
        }
        final Lotto lotto = new Lotto(lottoNumbers);
        final LottoAnalyzer lottoAnalyzer = new LottoAnalyzer(lotto);

        // when
        for (int i = 0; i < analyzeCount; i++) {
            lottoAnalyzer.analyze(lotto);
        }
        final LottoGameReport report = lottoAnalyzer.getReport();
        final int matchCount = report.getMatchCount(LottoPrize.JACKPOT);

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
        final Set<LottoNumber> lottoNumbers = new HashSet<>();
        for (int lottoNumber = Env.MIN_LOTTO_NUMBER; lottoNumber <= Env.COUNT_OF_LOTTO_NUMBER_IN_LOTTO; lottoNumber++) {
            lottoNumbers.add(new LottoNumber(lottoNumber));
        }
        final Lotto lotto = new Lotto(lottoNumbers);
        final LottoAnalyzer lottoAnalyzer = new LottoAnalyzer(lotto);

        // when
        for (int i = 0; i < analyzeCount; i++) {
            lottoAnalyzer.analyze(lotto);
        }
        final LottoGameReport report = lottoAnalyzer.getReport();
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
        final Set<LottoNumber> lottoNumbers = new HashSet<>();
        for (int lottoNumber = Env.MIN_LOTTO_NUMBER; lottoNumber <= Env.COUNT_OF_LOTTO_NUMBER_IN_LOTTO; lottoNumber++) {
            lottoNumbers.add(new LottoNumber(lottoNumber));
        }
        final Lotto lotto = new Lotto(lottoNumbers);
        final LottoAnalyzer lottoAnalyzer = new LottoAnalyzer(lotto);

        final int totalBuyingMoney = analyzeCount * Env.PRICE_OF_LOTTO;

        // when
        for (int i = 0; i < analyzeCount; i++) {
            lottoAnalyzer.analyze(lotto);
        }
        final LottoGameReport report = lottoAnalyzer.getReport();
        final Money returnOnInvestment = report.getReturnOnInvestment();

        final Money expect = new Money(LottoPrize.JACKPOT.getPrizeMoney() * analyzeCount / totalBuyingMoney);

        // then
        assertThat(returnOnInvestment).isEqualTo(expect);
    }
}
