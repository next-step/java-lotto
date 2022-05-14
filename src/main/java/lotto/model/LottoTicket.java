package lotto.model;

import lotto.exception.DuplicatedLottoNumberException;
import lotto.exception.InvalidLottoTicketSizeException;

import java.util.*;
import java.util.stream.Collectors;

public class LottoTicket {

    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
    }

    public LottoTicket(Integer[] nums) {
        List<LottoNumber> lottoNumbers = Arrays.stream(nums)
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        validate(lottoNumbers);

        this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
    }

    private void validate(List<LottoNumber> lottoNumbers) {
        if(lottoNumbers.size() != 6){
            throw new InvalidLottoTicketSizeException();
        }
        Set<LottoNumber> lottoNumberSet = Set.copyOf(lottoNumbers);
        if(lottoNumberSet.size() != 6){
            throw new DuplicatedLottoNumberException();
        }
    }

    public Rank getRank(LottoTicket winningNumbers, LottoNumber bonusBall){
        int rank = 0;
        for(LottoNumber lottoNumber: winningNumbers.getLottoNumbers()){
            if(this.lottoNumbers.contains(lottoNumber)){
                rank += 1;
            }
        }
        return Rank.of(rank, this.lottoNumbers.contains(bonusBall));
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
