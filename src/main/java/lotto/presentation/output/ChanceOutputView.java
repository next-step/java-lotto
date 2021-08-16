package lotto.presentation.output;

import lotto.domain.Chance;

public class ChanceOutputView {
    private static final String LOTTO_CHANCE_OUTPUT_COMMENT = "%d개를 구매했습니다.%n";

    public void output(Chance chance) {
        System.out.printf(LOTTO_CHANCE_OUTPUT_COMMENT, chance.getValue());
    }

}
