package lotto;

public class ResultView {
	public static final String LOTTO_PURCHASE_OUTPUT = "%d개를 구매했습니다.";
	public static final String LOTTO_RESULT = "당첨 통계 \n ---------";
	public static final String MATCHING_COUNT = "%d개 일치 (%d원) - %d개";
	public static final String TOTAL_REVENUE = "총 수익률은 %.2f입니다.";

	public static void print(String msg) {
		System.out.println(msg);
	}

	public static void print(String msg, int num) {
		System.out.println(String.format(msg, num));
	}

	public static void print(String msg, float num) {
		System.out.println(String.format(msg, num));
	}

	public static void print(String msg, long num1, int num2, long num3) {
		System.out.println(String.format(msg, num1, num2, num3));
	}
}
