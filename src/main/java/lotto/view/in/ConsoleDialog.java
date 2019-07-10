package lotto.view.in;

import java.util.Scanner;

/**
 * 콘솔을 이용해서 메세지 출력, 입력을 수행하는 입력구현 클래스
 */
public class ConsoleDialog implements SingleInputDialog {

	@Override
	public String execute(String message) {
		System.out.println(message);
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

}
