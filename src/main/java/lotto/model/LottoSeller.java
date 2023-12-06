package lotto.model;

public class LottoSeller {
    private static final int LOTTO_COST = 1000;
    private final int numberOfLotto;
    private final int numberOfManual;
    private final int numberOfAuto;

    public LottoSeller(Money money, Integer manualNumber) {
        numberOfLotto = calculatorNumberOfLotto(money.getMoney());
        numberOfManual = manualNumber;
        numberOfAuto = numberOfLotto - numberOfManual;
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
