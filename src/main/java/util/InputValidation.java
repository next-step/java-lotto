package util;

import domain.Lotto;

import static domain.Lotto.*;

public class InputValidation {
	private static final String WRONG_INPUT_LOTTO_NUMBERS_MESSAGE = "6자리 숫자를 ,을 이용해 입력해 주세요.";
	private static final String WRONG_INPUT_LOTTO_NUMBER_MESSAGE = "로또 번호의 범위는 " + LOTTO_MIN_NUMBER + "부터" + LOTTO_MAX_NUMBER + "까지입니다.";
	private static final String WRONG_INPUT_LOTTO_PRICE_SURPIX = "원단위로 입력해주세요.";
	private static final String WRONG_INPUT_NUMBER_FORMAT = "숫자를 입력해주세요.";
	private static final String WRONG_INPUT_BONUS_NUMBER = "로또번호에 보너스 번호가 포함될 수 없습니다.";

	public static Boolean checkNullAndEmpty(String input) {
		if (input == null || input.equals("")) {
			return Boolean.TRUE;
		}

		return Boolean.FALSE;
	}

	public static Boolean checkLottoPrice(Integer money) {
		if (money % LOTTO_PRICE > 0) {
			throw new NumberFormatException(LOTTO_PRICE + WRONG_INPUT_LOTTO_PRICE_SURPIX);

		}
		return Boolean.TRUE;
	}

	public static Boolean checkNumberFormat(String number) {
		try {
			Integer.parseInt(number);

		} catch (NumberFormatException e) {
			System.out.println(WRONG_INPUT_NUMBER_FORMAT);
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	public static Boolean checkInputMoney(String inputMoney) {
		Integer money = 0;

		try {
			money = Integer.parseInt(inputMoney);
			checkLottoPrice(money);

		} catch (NumberFormatException e) {
			System.out.println(WRONG_INPUT_NUMBER_FORMAT);
			return Boolean.FALSE;
		}

		return Boolean.TRUE;
	}

	public static Boolean checkInputLottoNumbers(String lottoNumbers) {
		String[] stringNumbers = lottoNumbers.split(",");

		if (stringNumbers.length != LOTTO_NUMBER_LENGTH) {
			System.out.println(WRONG_INPUT_LOTTO_NUMBERS_MESSAGE);
			return Boolean.FALSE;
		}

		for (int i = 0; i < LOTTO_NUMBER_LENGTH; i++) {
			if (!checkInputLottoNumber(stringNumbers[i])) return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	public static Integer parseInteger(String number) {
		return Integer.parseInt(number);
	}

	public static Boolean checkInputLottoNumber(String lottoNumber) {
		if (!checkNumberFormat(lottoNumber)) {
			return Boolean.FALSE;
		}

		Integer number = parseInteger(lottoNumber);

		if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
			System.out.println(WRONG_INPUT_LOTTO_NUMBER_MESSAGE);
			return Boolean.FALSE;
		}

		return Boolean.TRUE;
	}

	public static Boolean isContainBonus(Lotto winnerNumber, Integer bonusNumber) {
		if (winnerNumber.numbers().contains(bonusNumber)) {
			System.out.println(WRONG_INPUT_BONUS_NUMBER);
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}
}
