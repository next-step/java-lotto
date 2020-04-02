package step2.domain;

public class LottoGameInfo {

    private static final String MESSAGE_OF_MONEY_EXCEPTION = "로또 한장의 가격은 1000원 입니다.";
    private int money;
    private int countOfLotto;

    public LottoGameInfo(int money) {
        this.money = money;
        this.countOfLotto = buyLotto(money);
    }

    public int buyLotto(int money) {
        checkValidMoney(money);
        return money / 1000;
    }

    public void checkValidMoney(int money) {
        if(money < 1000 ) {
            throw new IllegalArgumentException(MESSAGE_OF_MONEY_EXCEPTION);
        }
    }

    public int getCountOfLotto() {
        return countOfLotto;
    }
}
