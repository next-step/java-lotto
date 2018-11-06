package lotto.domain.validator;

import com.google.common.base.Preconditions;
import lotto.domain.LottoConstants;

import java.util.List;
import java.util.function.Predicate;

/**
 * Created by hspark on 07/11/2018.
 */
public class PreviousWinningNumberValidator implements Validator<List<Integer>> {

	@Override
	public void valid(List<Integer> previousWinningNumber) {
		Preconditions.checkArgument(previousWinningNumber.size() == LottoConstants.LOTTO_NUMBER_COUNT,
			"로또 번호는 6자리여야합니다.");
		Preconditions.checkArgument(previousWinningNumber.stream().distinct().count() == LottoConstants.LOTTO_NUMBER_COUNT,
			"중복은 허용되지 않습니다.");
		Preconditions.checkArgument(!previousWinningNumber.stream().filter(lottoNumberRangePredicate()).findAny().isPresent(),
			"잘못된 로또 번호입니다.");
	}

	private Predicate<Integer> lottoNumberRangePredicate() {
		return i -> i > LottoConstants.LOTTO_MAX_NUMBER || i < LottoConstants.LOTTO_MIN_NUMBER;
	}
}
