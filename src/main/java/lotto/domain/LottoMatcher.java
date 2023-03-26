package lotto.domain;

import lotto.LottoNumber;
import lotto.LottoTicket;

public class LottoMatcher {
    private LottoTicket winningNumbers;
    private LottoNumber bonusNumber;

    private int matchCount;
    private boolean matchBouns;

    public LottoMatcher(LottoTicket winningNumbers, LottoNumber bonusNumber){
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int match(LottoTicket lottoTicket){
        matchCount = 0;
        matchBouns = false;

        for( LottoNumber lottoNumber : lottoTicket.getLottoNumbers()){
            matchAfter(lottoNumber);
        }
        if(winningNumbers.isInLottoNumber(bonusNumber)){
            matchBouns = true;
        }
        return matchCount;
    }

    public void matchAfter(LottoNumber lottoNumber){
        if(winningNumbers.isInLottoNumber(lottoNumber)){
            matchCount += 1;
        }
    }

    public int getMatchCount(){
        return this.matchCount;
    }

    public boolean isMatchBouns(){
        return this.matchBouns;
    }
}
