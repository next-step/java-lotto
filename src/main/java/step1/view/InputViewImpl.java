package step1.view;

import java.util.Scanner;

public class InputViewImpl implements InputView{
	public static final Scanner sc = new Scanner(System.in);
	public String getOperation() {
		return sc.nextLine();
	}
}
