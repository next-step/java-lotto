package lotto.domain;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoBundle;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.result.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProfitCalculatorTest {

    private static final double THIRD_PRIZE = 5000d;
    private static final int PURCHASE_MONEY = 14000;
    private static final int WIN_LOTTO_TICKET_NUMBER = 2;

    @DisplayName("곱셈으로 수익률을 계산해서 올바른 값이 나온다.")
    @Test
    public void calculate_ByMultiplyStrategy_CreateProfitRate() {

        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(Arrays.asList(1,2,3,10,11,12)));
        lottoList.add(new Lotto(Arrays.asList(1,2,3,21,22,23)));
        LottoBundle lottoBundle = new LottoBundle(lottoList);
        WinNumber winNumber = new WinNumber(new Lotto(Arrays.asList(1, 2, 3, 41, 42, 43)), LottoNumber.of(30));
        Record record = Record.extractRecord(lottoBundle, winNumber);

        ProfitCalculator profitCalculator = new ProfitCalculator(new MultiplyProfitRate());
        ProfitRate profitRate = profitCalculator.calculate(record.getRecord(), 14000);
        double value = profitRate.value();

        double result = THIRD_PRIZE * WIN_LOTTO_TICKET_NUMBER / PURCHASE_MONEY;
        result = Math.round(result * 100) / 100.0;
        Assertions.assertThat(Math.round(value * 100) / 100.0).isEqualTo(result);

    }
}
