package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.exception.InstanceCreateException;
import lotto.message.ErrorMessage;

public class LottoMachine {

	private static final int LOTTO_END_SIZE = 6;
	private static final int LOTTO_START_SIZE = 0;
	private static final int LOTTO_START_NUMBER = 1;
	private static final int LOTTO_END_NUMBER = 46;
	public static final List<Integer> lottoBalls = IntStream.range(LOTTO_START_NUMBER, LOTTO_END_NUMBER)
		.boxed()
		.collect(Collectors.toList());

	private LottoMachine() {
		throw new InstanceCreateException(ErrorMessage.LOTTO_MACHINE_CREATE_MESSAGE);
	}

	public static Lotto createLottoNumbers() {
		Collections.shuffle(lottoBalls);
		return new Lotto(lottoBalls.subList(LOTTO_START_SIZE, LOTTO_END_SIZE)
			.stream()
			.map(LottoNumber::new)
			.collect(Collectors.toList()));
	}
}
