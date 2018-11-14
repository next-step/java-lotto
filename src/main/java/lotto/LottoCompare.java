package lotto;

import java.util.List;

public class LottoCompare {
    private LottoBonusBall bonusBall;

    public LottoCompare(LottoBonusBall bonusBall){
       this.bonusBall = bonusBall;
    }


    public Rank compareNumber(Lotto lotto, WinningLotto winNumber) {
        int count = 0;
        List<Integer> lottoNumbers = lotto.getNumber();

        for (int num : winNumber.getNumber()) {
            if (lottoNumbers.contains(num)) {
                count++;
            }
        }
        return Rank.valueOf(count, this.bonusBall.isExistBonusBall(lotto));
    }

    public LottoResult match(List<Lotto> lotteries, WinningLotto winNumber){
        LottoResult result = new LottoResult();


        for(Lotto oneTicket : lotteries){
            result.calculateResult(compareNumber(oneTicket, winNumber));
        }
        return result;
    }

}
