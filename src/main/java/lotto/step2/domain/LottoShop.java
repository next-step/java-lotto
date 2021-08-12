package lotto.step2.domain;

public class LottoShop {
    private Lotto lotto;

    public LottoShop(int price) {
        if (price < 1000) {
            throw new IllegalArgumentException("돈이 부족합니다. 로또 1장의 가격은 1000원입니다.");
        }
        int lottoCount = price / 1000;
        this.lotto = new Lotto(lottoCount);
        sellLotto2(lottoCount);
    }
    public void sellLotto2(int lottoCount) {

    }
    public Lotto sellLotto() {
        return this.lotto;
    }
}
