package step2.dto;

import java.util.List;

public class PlayLottoDto {
	private final String moneyString;
	private final List<String> lottoStringList;

	public PlayLottoDto(String moneyString, List<String> lottoString) {
		this.moneyString = moneyString;
		this.lottoStringList = lottoString;
	}

	public String getMoneyString() {
		return moneyString;
	}

	public List<String> getLottoStringList() {
		return lottoStringList;
	}
}
