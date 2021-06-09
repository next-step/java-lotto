package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class WinningLottoTicket {

    private LottoTicket winningLottoTicket;
    private LottoNumber bonusNumber;
    public WinningLottoTicket(LottoTicket winningLottoTicket, LottoNumber bonusNumber) {
        this.winningLottoTicket = winningLottoTicket;
        this.bonusNumber = bonusNumber;
    }

    public LottoRank getRankOfTicket(LottoTicket lottoTicket){
        int totalNumContains = 0;
        for (int i=0; i<lottoTicket.size(); i++){
            totalNumContains += howManyContains(lottoTicket.get(i));
        }
        return LottoRank.of(totalNumContains, lottoTicket.contains(bonusNumber));
    }

    private int howManyContains(LottoNumber lottoNumber){
        if (winningLottoTicket.contains(lottoNumber)){
            return 1;
        }
        return 0;
    }
}
