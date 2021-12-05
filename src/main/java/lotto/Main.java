package lotto;

import lotto.domain.Person;
import lotto.domain.Store;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Store lottoStore = new Store();
        InputView inputView = new InputView(new Scanner(System.in));
        int amount = inputView.nextInteger("구입금액을 입력해 주세요.");
        Person person = new Person(amount);
        lottoStore.sellTo(person);
        ResultView.printMyLottos(person);

    }
}
