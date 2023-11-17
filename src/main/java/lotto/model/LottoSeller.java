package lotto.model;

public class LottoSeller {
    private static int LOTTO_COST = 1000;
    private final int numberOfLotto;
    public LottoSeller(String input) {
        checkInput(input);
        int money = parsingInteger(input);
        checkMoney(money);
        this.numberOfLotto = calculatorNumberOfLotto(money);
    }

    private void checkInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("알맞은 숫자를 입력해주세요.");
        }
    }

    private Integer parsingInteger(String input) {
        return Integer.parseInt(input);
    }

    private void checkMoney(Integer money) {
        if (money<1000) {
            throw new IllegalArgumentException("로또를 한장도 구매할 수 없습니다.");
        }
    }

    private Integer calculatorNumberOfLotto(Integer money) {
        return Math.floorDiv(money, LOTTO_COST);
    }

    public Integer getNumberOfLotto() {
        return numberOfLotto;
    }


}
