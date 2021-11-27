package lotto.model;

import common.model.Number;
import lotto.application.Constant;
import lotto.factory.LottoFactory;
import lotto.factory.LottoNumberFactory;
import lotto.factory.LottoNumbersFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStoreTest {

    Lotto lotto;
    LottoWinner winner;

    @BeforeEach
    void setUp() {
        List<LottoNumber> numbers = new ArrayList<>();
        for (int i = 0; i < Constant.LOTTO_NUMBERS_SIZE; i++) {
            numbers.add(LottoNumberFactory.manualCreateNumber(7 * i + 3));
        }

        lotto = LottoFactory.manualCreateSingleLotto(LottoNumbersFactory.manualCreateNumbers(numbers));
        LottoNumber bonus = LottoNumberFactory.manualCreateNumber("45");
        winner = new LottoWinner(LottoNumbersFactory.manualCreateNumberList("3, 10, 17, 42, 43, 44"), bonus);
    }

    @Test
    @DisplayName("수익률 계산")
    void calculateRateOfRevenue() {
        LottoNumbers lottoNumbers = LottoNumbersFactory.manualCreateNumbers("1, 2, 3, 4, 5, 6");
        Lotto lotto = LottoFactory.manualCreateSingleLotto(lottoNumbers);
        LottoNumber bonus = LottoNumberFactory.manualCreateNumber(7);
        LottoWinner winner = new LottoWinner(LottoNumbersFactory.manualCreateNumberList("1, 2, 3, 11, 12, 13"), bonus);

        Map<LottoRank, Number> result = lotto.matchAll(winner);
        float rateOfRevenue = LottoStore.calculateRateOfRevenue(result, 1000);
        assertThat(rateOfRevenue).isEqualTo(5);

    }
}