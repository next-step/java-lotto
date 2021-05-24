package lotto.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lotto.Lotto;
import lotto.Lottos;
import lotto.Money;
import lotto.Store;

public class InputView {
	private Lottos lottos;
	private Lotto prizeLotto;

	public void input() {
		Scanner sc = new Scanner(System.in);
		Money amount = inputAmount(sc);

		lottos = Store.buy(amount);
		printLottos();

		prizeLotto = inputPrizeLotto(sc);
	}

	private void printLottos() {
		for (Lotto lotto : lottos.findAll()) {
			System.out.println(lotto.numbers());
		}
	}

	private Money inputAmount(Scanner sc) {
		System.out.println("구입금액을 입력해 주세요.");
		Money amount = new Money(sc.nextLong());
		sc.nextLine();
		return amount;
	}

	private Lotto inputPrizeLotto(Scanner sc) {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		String line = sc.nextLine();
		String[] splits = line.split(",");
		List<Integer> numbers = new ArrayList<>();
		for (String e : splits) {
			numbers.add(Integer.parseInt(e.trim()));
		}
		return new Lotto(numbers);
	}

	public Lottos lottos() {
		return lottos;
	}

	public Lotto prizeLotto() {
		return prizeLotto;
	}
}
