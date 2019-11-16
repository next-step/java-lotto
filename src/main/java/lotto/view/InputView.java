package lotto.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class InputView {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final int NUMBER_COUNT = 6;

	public static int getPurchaseAmount() throws IOException {
		System.out.println("구매금액을 입력해 주세요.");
		int purchaseAmount = Integer.parseInt(br.readLine());

		if (purchaseAmount < 1000) {
			throw new IllegalArgumentException();
		}

		return purchaseAmount;
	}

	public static int[] getWinningNumbers() throws IOException {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		int[] numbers = Arrays.stream(br.readLine().replaceAll(" ", "").split(","))
				.mapToInt(Integer::parseInt)
				.toArray();

		if (numbers.length != NUMBER_COUNT) {
			throw new IllegalArgumentException();
		}

		return numbers;
	}

}
