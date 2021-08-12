package step3;

import step3.domain.Customer;
import step3.view.InputView;

public class LottoApp {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        Customer customer = new Customer();

        int numOfLotto = inputView.requestInput();
        customer.buyLotto(numOfLotto);
    }

}
