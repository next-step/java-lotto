package lotto.model;

public class LottoSeller {
    private static int LOTTO_COST = 1000;
    private final int numberOfLotto;
    private final int numberOfManual;
    private final int numberOfAuto;

    public LottoSeller(Integer money, Integer manualNumber) {
        isNullCost(money);
        minimalMoney(money);
        numberOfLotto = calculatorNumberOfLotto(money);
        numberOfManual = manualNumber;
        numberOfAuto = numberOfLotto - numberOfManual;
    }

    private void isNullCost(Integer money) {
        if (money == null) {
            throw new IllegalArgumentException("알맞은 금액을 입력해주세요.");
        }
    }

    private void minimalMoney(Integer money) {
        if (money < 1000) {
            throw new IllegalArgumentException("로또를 한장도 구매할 수 없습니다.");
        }
    }

    private Integer calculatorNumberOfLotto(Integer money) {
        return Math.floorDiv(money, LOTTO_COST);
    }

    public Integer getNumberOfLotto() {
        return numberOfLotto;
    }

    public Integer getNumberofManual() {
        return numberOfManual;
    }

    public Integer getNumberOfAuto() {
        return numberOfAuto;
    }


}
