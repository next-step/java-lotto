package lotto.presentation.output;

public class ChanceOutputView {
    private static final String LOTTO_CHANCE_OUTPUT_COMMENT = "%d개를 구매했습니다.%n";

    public void output(int chance) {
        System.out.printf(LOTTO_CHANCE_OUTPUT_COMMENT, chance);
    }

}
