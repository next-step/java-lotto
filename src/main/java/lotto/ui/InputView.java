package lotto.ui;

import lotto.dto.LottoNumberDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
	private static final String SPEND_MONEY_INPUT_MSG = "구입 금액을 입력해 주세요.";
	private static final String GET_PASSIVE_NUMBER_COUNT_MSG = "수동으로 구매할 로또 수를 입력해 주세요.";
	private static final String GET_PASSIVE_NUMBERS_MSG = "수동으로 구매할 번호를 입력해 주세요.";
	private static final String GET_WINNING_NUMBER_MSG = "지난 주 당첨 번호를 입력해 주세요.";
	private static final String GET_WINNING_BONUS_MSG = "보너스 볼을 입력해 주세요.";

	private final Scanner scanner;

	public InputView(Scanner scanner) {
		this.scanner = scanner;
	}

	public static InputView getInstance() {
		Scanner scanner = new Scanner(System.in);
		return new InputView(scanner);
	}

	public long getSpentMoney() {
		System.out.println(SPEND_MONEY_INPUT_MSG);
		return Integer.parseInt(scanner.nextLine());
	}

	public LottoTickets getPassiveLottoNumbers() {
		System.out.println(GET_PASSIVE_NUMBER_COUNT_MSG);
		int count = Integer.parseInt(scanner.nextLine());

		System.out.println(GET_PASSIVE_NUMBERS_MSG);
		return getPassiveLottoNumbers(count);
	}

	private LottoTickets getPassiveLottoNumbers(int count) {
		List<LottoTicket> lottoNumbers = new ArrayList<>(count);
		for (int i = 0; i < count; i++) {
			LottoTicket numbers = getLottoTicket(scanner.nextLine());
			lottoNumbers.add(numbers);
		}
		return new LottoTickets(lottoNumbers);
	}

	private LottoTicket getLottoTicket(String s) {
		return new LottoTicket(
				Arrays.stream(s.split(","))
						.map(Integer::parseInt)
						.collect(Collectors.toList()));
	}

	public LottoNumberDto getWonLastWeekLottoNumbers() {
		System.out.println(GET_WINNING_NUMBER_MSG);
		String numberString = scanner.nextLine();
		LottoTicket numbers = getLottoTicket(numberString);

		return new LottoNumberDto(numbers.getLottoNumbers());
	}

	public int getWonLastWeekBonusNumber() {
		System.out.println(GET_WINNING_BONUS_MSG);
		return Integer.parseInt(scanner.nextLine());
	}
}
