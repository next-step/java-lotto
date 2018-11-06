package lotto.domain.validator;

import com.google.common.base.Preconditions;
import lotto.domain.LottoConstants;

/**
 * Created by hspark on 07/11/2018.
 */
public class LottoPurchaseAmountValidator implements Validator<Integer> {
	@Override
	public void valid(Integer lottoPurchaseAmount) {
		Preconditions.checkArgument(lottoPurchaseAmount >= LottoConstants.LOTTO_TICKET_AMOUNT,
			"로또 구매 금액 이하입니다.");
		Preconditions.checkArgument(lottoPurchaseAmount % LottoConstants.LOTTO_TICKET_AMOUNT == 0,
			"1000원 단위로 입력해 주세요.");
	}
}
