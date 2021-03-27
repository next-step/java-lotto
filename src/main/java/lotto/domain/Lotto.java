package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
	private static final int LOTTO_NUMBER_SIZE = 6;
	private final List<LottoNumber> gameNumberList;

	public Lotto(String inputNumber) {
		this(() -> {
			List<LottoNumber> gameNumberList = new ArrayList<>();
			Arrays.stream(inputNumber.split(","))
				.forEach((numbers) -> gameNumberList.add(new LottoNumber(Integer.valueOf(numbers.trim()))));
			return gameNumberList;
		});
	}

	public Lotto(MakeStrategy makeStrategy) {
		validateSize(makeStrategy.makeGameNumberList());
		validateDuplicate(makeStrategy.makeGameNumberList());
		this.gameNumberList = makeStrategy.makeGameNumberList();
		Collections.sort(this.gameNumberList);
	}

	public List<LottoNumber> getGameNumberList() {
		return gameNumberList;
	}

	private void validateSize(List<LottoNumber> gameNumberList) {
		if (isNumberSizeInValid(gameNumberList.size())) {
			throw new IllegalArgumentException("로또 번호는 반드시 6자리로 구성 돼야 합니다.");
		}
	}

	private void validateDuplicate(List<LottoNumber> gameNumberList) {
		Set<LottoNumber> nonDuplicateNumbers = new HashSet<>(gameNumberList);
		if (isNumberSizeInValid(nonDuplicateNumbers.size())) {
			throw new IllegalArgumentException("로또 번호들은 중복될 수 없습니다.");
		}
	}

	private boolean isNumberSizeInValid(int numberSize) {
		if (numberSize != LOTTO_NUMBER_SIZE) {
			return true;
		}
		return false;
	}
}
