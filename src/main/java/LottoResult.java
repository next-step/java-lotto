import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class LottoResult {

	private Map<LottoRewardType, Integer> lottoRewardMap;

	public LottoResult(){
		this(new EnumMap(LottoRewardType.class));
	}

	LottoResult(Map<LottoRewardType, Integer> lottoRewardMap){
		if(lottoRewardMap == null){
			throw new IllegalArgumentException();
		}
		init(lottoRewardMap);
		this.lottoRewardMap = lottoRewardMap;
	}

	public void add(final int collect){
		LottoRewardType lottoRewardType = LottoRewardType.of(collect);
		lottoRewardMap.computeIfPresent(lottoRewardType, ((key, value) -> value + lottoRewardType.reward()));
	}

	public int sum(final LottoRewardType lottoRewardType){
		return lottoRewardMap.getOrDefault(lottoRewardType, 0);
	}

	private void init(Map<LottoRewardType, Integer> lottoRewardMap){
		Arrays.stream(LottoRewardType.values())
			  .forEach(type -> lottoRewardMap.putIfAbsent(type, 0));
	}
}
