package com.woowahan.lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.woowahan.lotto.constant.Message;
import com.woowahan.lotto.util.ValidationUtil;

public class PurchaseInput {
	private static final String DELIMITER_WIN_NUMBER = ",";

	private final int purchaseAmount;
	private final List<List<LottoNo>> manualNumbers = new ArrayList<>();

	private PurchaseInput(String purchaseAmount, List<String> stringLottos) {
		validatePurchaseAmount(purchaseAmount);
		this.purchaseAmount = Integer.parseInt(purchaseAmount);
		for (String stringLotto : stringLottos) {
			this.manualNumbers.add(validateStringLotto(stringLotto));
		}
		validateManualCnt();
	}

	private void validateManualCnt() {
		if (this.purchaseAmount - getManualPurchaseAmount() < 0) {
			throw new IllegalArgumentException(Message.MSG_WRONG_MANUAL_CNT);
		}
	}

	private List<LottoNo> validateStringLotto(String stringLotto) {
		if (ValidationUtil.isNullOrEmpty(stringLotto)) {
			throw new IllegalArgumentException(Message.MSG_NULL_OR_EMPTY);
		}
		List<String> result = parseStringLotto(stringLotto);
		if (result.size() != Lotto.LOTTO_NUMBER_LENGTH
			|| ValidationUtil.hasNotNumber(result)
			|| ValidationUtil.hasWrongNumber(result)) {
			throw new IllegalArgumentException(Message.MSG_WRONG_NUMBER);
		}
		return result.stream()
			.map(numberString -> LottoNo.of(Integer.parseInt(numberString)))
			.collect(Collectors.toList());
	}

	private List<String> parseStringLotto(String input) {
		String[] splitNames = input.split(DELIMITER_WIN_NUMBER);
		return Arrays.stream(splitNames)
			.map(String::trim)
			.collect(Collectors.toList());
	}

	public static PurchaseInput of(String purchaseAmount, List<String> stringLottos) {
		return new PurchaseInput(purchaseAmount, stringLottos);
	}

	private void validatePurchaseAmount(String value) {
		if (ValidationUtil.isNotNumber(value)
			|| ValidationUtil.isZeroOrNegative(value)
			|| ValidationUtil.existRemainder(Integer.parseInt(value), Lotto.LOTTO_PRICE)) {
			throw new IllegalArgumentException(Message.MSG_WRONG_AMOUNT);
		}
	}

	public int getAutoPurchaseAmount() {
		return this.purchaseAmount - getManualPurchaseAmount();
	}

	public int getManualPurchaseAmount() {
		return Lotto.LOTTO_PRICE * getManualLottoCount();
	}

	public int getManualLottoCount() {
		return this.manualNumbers.size();
	}

	public List<List<LottoNo>> getManualNumbers() {
		return manualNumbers;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("PurchaseInput{");
		sb.append("purchaseAmount=").append(purchaseAmount);
		sb.append('}');
		return sb.toString();
	}
}
