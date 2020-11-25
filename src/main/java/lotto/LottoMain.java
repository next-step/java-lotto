package lotto;


/**
 * 1. viewcontroller, inputview, resultview 분리. 로또 숫자, 지난 주 당첨 번호 입 출력.
 * 2. 당첨 통계 및 총 수익률
 */
public class LottoMain {

    public static void main(String[] args) {
        LottoFactory.createViewController().execute();
    }
}
