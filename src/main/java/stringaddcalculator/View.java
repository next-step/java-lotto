package stringaddcalculator;

import java.util.Scanner;

/**
 * @author : byungkyu
 * @date : 2020/12/11
 * @description :
 **/
public class View {
	private static final Scanner scanner = new Scanner(System.in);

	public static int input() {
		return StringAddCalculator.splitAndSum(scanner.nextLine());
	}

	public static void print(int arg) {
		System.out.println(arg);
	}
}
