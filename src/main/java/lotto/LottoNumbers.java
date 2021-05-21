package lotto;

import ui.ResultView;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class LottoNumbers {
	private final List<LottoNumber> lottoNumberList;

	private LottoNumbers(){
		throw new UnsupportedOperationException();
	}

	public LottoNumbers(List<Integer> numbers){
		if(numbers == null || numbers.isEmpty()){
			throw new IllegalArgumentException();
		}
		List<LottoNumber> lottoNumberList = numbers.stream()
												   .map(LottoNumber::new)
												   .sorted()
												   .collect(Collectors.toList());
		this.lottoNumberList = Collections.unmodifiableList(lottoNumberList);
	}

	public int matches(final LottoNumbers parameter){
		int sameNumber = 0;
		for(LottoNumber number : parameter.lottoNumberList){
			sameNumber += match(number);
		}
		return sameNumber;
	}

	private int match(final LottoNumber number){
		if(this.lottoNumberList.contains(number)){
			return 1;
		}
		return 0;
	}

	public void print(){
		ResultView.printMessage(lottoNumberList.toString());
	}
}
