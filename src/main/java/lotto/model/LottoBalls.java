package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoBalls {

	private final List<LottoNumber> lottoBalls;

	public LottoBalls(List<Integer> lottoBalls) {
		this.lottoBalls = Collections.unmodifiableList(
			lottoBalls.stream().map(LottoNumber::new).collect(Collectors.toList()));
	}

	public List<LottoNumber> getLottoBalls() {
		return lottoBalls;
	}
}
