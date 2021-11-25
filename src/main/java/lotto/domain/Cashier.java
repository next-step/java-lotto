package lotto.domain;

public class Cashier {

    public int calculateCountAvailable(int money) {
        validate(money);
        return money / LottoShop.LOTTO_PRICE; //LottoShop 상수가 여기 있어도 괜찮을까요...? 의존성 관련해서 Cashier가 LottoShop에 의존하고 있다고 말하는 것이 맞나요? 의존해도 괜찮을까요?
    }

    private void validate(int money) {
        if (money < LottoShop.LOTTO_PRICE) {
            throw new IllegalArgumentException("해당 금액으로는 로또를 사실 수 없습니다.");
        }
    }

    public Lottos pay(int money) {
        int count = calculateCountAvailable(money);
        return new Lottos(count);
    }

}
