package lotto.step2fixture.domain;

import lotto.step2.domain.WinningLottoNumbers;

import java.util.Arrays;

public class WinningLottoNumbersFixture {
    public static final WinningLottoNumbers WINNING_LOTTO_NUMBERS = new WinningLottoNumbers(Arrays.asList(LottoNumberFixture.ONE, LottoNumberFixture.TWO, LottoNumberFixture.THREE, LottoNumberFixture.FOUR, LottoNumberFixture.FIVE, LottoNumberFixture.SIX), LottoNumberFixture.THIRTY);
}
