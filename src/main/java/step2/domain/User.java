package step2.domain;

public class User {
    private String money;
    private Lotto myLotto;

    public User(String money) {
        this.money = money;
    }

    public String getMoney() {
        return money;
    }

    public void setMyLotto(Lotto lotto) {
        this.myLotto = lotto;
    }
}
