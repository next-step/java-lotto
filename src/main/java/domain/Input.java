package domain;

import java.util.Scanner;

public class Input {

	private static Integer UNIT = 1000;

	private Integer account;
	private Scanner scanner;

	public Input() {
		this.scanner = new Scanner(System.in);
	}

	public void setAccount() {
		System.out.println("구입 금액을 입력해주세요.");
		this.account = scanner.nextInt();
		System.out.println(getLottoCount() + "개를 구매했습니다.");
	}

	private Integer getLottoCount() {
		return this.account / UNIT;
	}
}
