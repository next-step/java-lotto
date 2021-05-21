import java.util.ArrayList;
import java.util.List;

public class LottoNumbersFactory {

	private List<LottoNumbers> lottoList;

	public LottoNumbersFactory(){
		lottoList = new ArrayList<>();
	}

	public void add(final LottoNumbers lottoNumbers){
		this.lottoList.add(lottoNumbers);
	}

	public int size(){
		return this.lottoList.size();
	}
}
