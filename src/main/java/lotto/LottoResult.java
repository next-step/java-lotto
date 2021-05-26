package lotto;

import exception.LottoException;
import type.DecimalType;
import type.LottoRewardType;
import utils.NumberUtils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

import static type.LottoExceptionType.NULL_PARAMETER;

public final class LottoResult {

	private static final BigDecimal DEFAULT_REVENUE_VALUE = BigDecimal.ZERO;
	private Map<LottoRewardType, Integer> lottoRewardMap;

	public LottoResult() {
		this(new EnumMap(LottoRewardType.class));
	}

	LottoResult(final Map<LottoRewardType, Integer> lottoRewardMap) {
		checkNull(lottoRewardMap);
		init(lottoRewardMap);
		this.lottoRewardMap = lottoRewardMap;
	}

	private void checkNull(final Map<LottoRewardType, Integer> lottoRewardMap) {
		if (Objects.isNull(lottoRewardMap)) {
			throw LottoException.of(NULL_PARAMETER);
		}
	}

	public void add(final LottoRewardType lottoRewardType) {
		lottoRewardMap.computeIfPresent(lottoRewardType, ((key, value) -> value += 1));
	}

	public int count(final LottoRewardType lottoRewardType) {
		return lottoRewardMap.getOrDefault(lottoRewardType, 0);
	}

	private void init(Map<LottoRewardType, Integer> lottoRewardMap) {
		Arrays.stream(LottoRewardType.values())
			  .forEach(type -> lottoRewardMap.putIfAbsent(type, 0));
	}

	public BigDecimal calculateRevenue(final LottoMoney lottoMoney) {
		if (lottoMoney == null) {
			return DEFAULT_REVENUE_VALUE;
		}
		return NumberUtils.mathRound(BigDecimal.valueOf(sumRevenue()),
									 BigDecimal.valueOf(lottoMoney.price()),
									 DecimalType.PLACE_TWO);
	}

	private int sumRevenue() {
		return lottoRewardMap.entrySet()
							 .stream()
							 .filter(entry -> entry.getKey() != LottoRewardType.NONE)
							 .map(entry -> entry.getKey().reward() * entry.getValue())
							 .reduce(0, Integer::sum);
	}

	public Map<LottoRewardType, Integer> lottoRewardMap() {
		return this.lottoRewardMap;
	}
}
