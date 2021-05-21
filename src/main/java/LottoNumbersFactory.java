import java.util.ArrayList;
import java.util.List;

public class LottoNumbersFactory {

	private List<LottoNumbers> lottoList;

	public LottoNumbersFactory(){
		this(new ArrayList<>());
	}

	LottoNumbersFactory(final List<LottoNumbers> lottoList){
		this.lottoList = lottoList;
	}

	public void add(final LottoNumbers lottoNumbers){
		this.lottoList.add(lottoNumbers);
	}

	public LottoResult summary(final LottoNumbers winningLottoNumbers){
		LottoResult result = new LottoResult();
		if(size() == 0){
			return result;
		}

		lottoList.stream()
				 .map(lottoNumbers -> lottoNumbers.matches(winningLottoNumbers))
				 .forEach(result::add);
		return result;
	}

	public int size(){
		return this.lottoList.size();
	}
}
