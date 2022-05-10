package lotto.model;

import java.util.Collections;
import java.util.List;

public class LottoTicket {

    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
    }

    private void validate(List<LottoNumber> lottoNumbers) {
        if(lottoNumbers.size() != 6){
            throw new IllegalArgumentException("로또는 6개의 번호로 구성되어야합니다.");
        }
    }

    public Rank getRank(LottoTicket winningNumbers){
        int rank = 0;
        for(LottoNumber lottoNumber: winningNumbers.getLottoNumbers()){
            if(this.lottoNumbers.contains(lottoNumber)){
                rank += 1;
            }
        }
        return Rank.of(rank);
    }

    private List<LottoNumber> getLottoNumbers(){
        return lottoNumbers;
    }

    @Override
    public String toString(){
        int n = lottoNumbers.size();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i=0; i<n; i++){
            sb.append(lottoNumbers.get(i));
            if(i != n-1){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}
