package step3.domain;

public class Customer {
    private static final LottoMachine lottoMachine = new LottoMachine();

    public void buyLotto(int numOfLotto) {
        lottoMachine.issue(numOfLotto);
    }
}
