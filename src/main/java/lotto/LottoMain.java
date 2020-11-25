package lotto;


/**
 * 1. viewcontroller, inputview, resultview 분리. 로또 숫자,
 * 2. 지난 주 당첨 번호 입력하면 일치 갯수 파악해주는 기능
 * 3. 당첨 통계 및 수익률
 */
public class LottoMain {

    public static void main(String[] args) {
        LottoFactory.createViewController().execute();
    }
}
