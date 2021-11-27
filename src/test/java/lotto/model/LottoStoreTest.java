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
    @DisplayName("로또 번호 당첨 확인")
    void match() {
        LottoReport report = LottoStore.report(lotto, winner);//[3, 10, 17, 24, 31, 38] 4등
        assertThat(report.getLottoRankNumbers().get(LottoRank.FIFTH)).isEqualTo(new Number(1));
    }
}