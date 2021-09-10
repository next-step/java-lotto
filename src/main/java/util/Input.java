package util;

import domain.Account;
import domain.Lotto;
import domain.Number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Input {

	private static final Integer INIT_NUMBER = 0;

	private Integer account;
	private Scanner scanner;

	public Input() {
		this.scanner = new Scanner(System.in);
	}

	public Account setAccount() {
		System.out.println("구입 금액을 입력해주세요.");
		this.account = scanner.nextInt();
		return new Account(account);
	}

	public void viewLottoCount(Integer lottoCount) {
		System.out.println(lottoCount + "개를 구매했습니다.");
	}

	public Lotto lottoWinningNumber() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		List<String> numbers = new ArrayList<>(Arrays.asList(scanner.next().split(",")));
		return new Lotto(numbers.stream().map(data -> new Number(Integer.parseInt(data))).collect(Collectors.toList()));
	}

	public Number setBonusNumber() {
		System.out.println("보너스 볼을 입력해주세요.");
		Integer bonusNumber = scanner.nextInt();
		return new Number(bonusNumber);
	}

	public List<Lotto> getManualLotto() {
		System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
		Integer count = scanner.nextInt();
		System.out.println("수동으로 구매할 번호를 입력해 주세요.");
		List<Lotto> lottos = new ArrayList<>();
		for (int number = INIT_NUMBER ; number < count ; ++number) {
			lottos.add(manualLotto());
		}
		return lottos;
	}

	public Lotto manualLotto() {
		List<String> numbers = new ArrayList<>(Arrays.asList(scanner.next().split(",")));
		return new Lotto(numbers.stream().map(data -> new Number(Integer.parseInt(data))).collect(Collectors.toList()));
	}
}
