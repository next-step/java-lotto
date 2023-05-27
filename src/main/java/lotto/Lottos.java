package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {

    private List<Lotto> lottoList;

    public Lottos(int totalPrice, int price, LottoBallPolicy lottoBallPolicy) {
        lottoList = new ArrayList<>();

        for (int i = 0; i < calculateLottoSize(totalPrice, price); i++) {
            lottoBallPolicy.getLottoNumber(Lotto.getMaxSize());
            lottoList.add(createLottoByPolicy(lottoBallPolicy, price));
        }
    }

    private int calculateLottoSize(int totalPrice, int price){
        return totalPrice / price;
    }

    public Lotto createLottoByPolicy(LottoBallPolicy lottoBallPolicy, int price) {
        return Lotto.createLotto(lottoBallPolicy.getLottoNumber(Lotto.getMaxSize()), price);
    }

    public List<StatisticsNumber> matchedLottoCount(WinnigLotto winningLotto){
        List<StatisticsNumber> matchedCountList = new ArrayList<>();
        for (Lotto lotto : lottoList) {
            int count = lotto.equalsCount(winningLotto.getWinnigLottoNumbers());
            boolean isBonusNumberMatched = lotto.matchBonusNumber(winningLotto.getLottoBonusNumber());
            count += isBonusNumberMatched ? 1 : 0;
            matchedCountList.add(new StatisticsNumber(count, isBonusNumberMatched));
        }

        return matchedCountList;
    }

    public List<Lotto> getLottoList() {
        return Collections.unmodifiableList(lottoList);
    }

    public int getLottoListSize(){
        return lottoList.size();
    }

    public int getLottoTotalPrice(){
        return lottoList.stream()
                .map(Lotto::getPrice)
                .reduce(Integer::sum)
                .orElse(0);
    }
}
