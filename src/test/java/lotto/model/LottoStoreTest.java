package lotto.model;

import lotto.application.Constant;
import lotto.factory.LottoNumberFactory;
import lotto.factory.LottoNumbersFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStoreTest {

    Lotto lotto;
    LottoWinner winner;

    @BeforeEach
    void setUp() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < Constant.LOTTO_NUMBERS_SIZE; i++) {
            lottoNumbers.add(LottoNumberFactory.from(7 * i + 3));
        }

        lotto = new Lotto(Collections.singletonList(LottoNumbersFactory.from(lottoNumbers)));
        LottoNumber bonus = LottoNumberFactory.from("45");
        winner = LottoNumbersFactory.of("3, 10, 17, 42, 43, 44", bonus);
    }

    @Test
    @DisplayName("수익률 계산")
    void calculateRateOfRevenue() {
        LottoNumbers lottoNumbers = LottoNumbersFactory.from("1, 2, 3, 4, 5, 6");
        Lotto lotto = new Lotto(Collections.singletonList(lottoNumbers));
        LottoNumber bonus = LottoNumberFactory.from(7);
        LottoWinner winner = LottoNumbersFactory.of("1, 2, 3, 11, 12, 13", bonus);

        LottoReport report = lotto.matchAll(winner);
        float rateOfRevenue = report.calculateRateOfRevenue(1000);
        assertThat(rateOfRevenue).isEqualTo(5);

    }
}