package lotto.presentation.output;

import lotto.domain.Chance;

public class ChanceOutputView {
    private static final String LOTTO_CHANCE_OUTPUT_COMMENT = "수동으로 %d장, 자동으로 %d개를 구매했습니다.%n";

    public void output(Chance manualChance, Chance autoChance) {
        System.out.printf(LOTTO_CHANCE_OUTPUT_COMMENT, manualChance.getValue(), autoChance.getValue());
    }

}
