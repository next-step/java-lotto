package lotto.presentation.output;

public class LottoChanceOutputView {
    private static final String LOTTO_CHANCE_OUTPUT_COMMENT = "%d개를 구매했습니다.";

    public void output(int chance){
        System.out.println(String.format(LOTTO_CHANCE_OUTPUT_COMMENT, chance));
    }

}
