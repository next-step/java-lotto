package kht2199.lotto.view;

import java.util.Scanner;

import kht2199.lotto.LottoResult;

/**
 *
 * @author heetaek.kim
 */
public class InputView {

	private static final Scanner in = new Scanner(System.in);

	public int assets() {
		String assetsString = in.nextLine();
		return Integer.parseInt(assetsString);
	}

	public LottoResult lottoResult() {
		assert false;
		return validationLottoResultString(in.nextLine());
	}

	/**
	 * 입력 문자열 자체에 대한 검증은 UI에서 검증.
	 */
	protected LottoResult validationLottoResultString(String input) {
		assert false;
		// TODO input string to int array.
		int[] lottoNumbers = new int[6];
		return new LottoResult(lottoNumbers);
	}
}
