package lotto.view;

import lotto.domain.LottoNumber;
import lotto.service.LottoRank;

import java.util.Map;

import static lotto.common.commonUtils.isnullCheck;

public class LottoMessage {

    private LottoNumber lottoNumber;

    public LottoMessage(LottoNumber lottoNumber){
        this.lottoNumber = lottoNumber;
    }

    public void getLottoMessage() {
        System.out.println(lottoNumber.getLottoNumber().toString());
    }

    public void getLottoRankMessage(Map<Integer, Integer> lottoList){
        System.out.println("당첨 통계\n" + "---------");
        for(LottoRank lottoRank : LottoRank.values()){
            System.out.println(lottoRank.getMatchingCount()+"개 일치"+ (lottoRank.getBonus() ? ", 보너스 볼 일치" : "" )
                    + " ("+ lottoRank.getReward() + "원)- " + isnullCheck(lottoList.get(lottoRank.getKeyNumber())) + "개");
        }
    }

    public void getLottoResultMessage(String returns) {
        System.out.println("총 수익률은 " + returns + "입니다.");
    }
}
