package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {

    private List<Lotto> lottoList;

    public Lottos(int count, LottoBallPolicy lottoBallPolicy, int price) {
        lottoList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottoBallPolicy.getLottoNumber(Lotto.getMaxSize());
            lottoList.add(createLottoByPolicy(lottoBallPolicy, price));
        }
    }

    public Lotto createLottoByPolicy(LottoBallPolicy lottoBallPolicy, int price) {
        return Lotto.createLotto(lottoBallPolicy.getLottoNumber(Lotto.getMaxSize()), price);
    }

    public List<Integer> matchedLottoCount(Lotto winningLotto){
        List<Integer> matchedCountList = new ArrayList<>();
        for (Lotto lotto : lottoList) {
            matchedCountList.add(lotto.equalsCount(winningLotto.getLottoNumbers()));
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
