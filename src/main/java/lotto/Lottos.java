package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {

    private List<Lotto> lottoList;

    public Lottos(int inputPrice, int price, LottoBallPolicy lottoBallPolicy) {
        lottoList = new ArrayList<>();

        for (int i = 0; i < LottoCount(inputPrice, price); i++) {
            lottoBallPolicy.getLottoNumber(Lotto.getMaxSize());
            lottoList.add(createLottoByPolicy(lottoBallPolicy, price));
        }
    }

    private static int LottoCount(int inputPrice, int price) {
        return inputPrice / price;
    }

    public Lottos(int inputPrice, int price, List<Numbers> numbersList) {
        lottoList = new ArrayList<>();

        if(LottoCount(inputPrice, price) - numbersList.size() < 0){
            throw new IllegalArgumentException("수동 갯수는 구입금액을 넘을 수 없습니다.");
        }

        for(Numbers numbers : numbersList){
            lottoList.add(Lotto.createLotto(numbers.getNumbers(), price));
        }
    }

    public Lotto createLottoByPolicy(LottoBallPolicy lottoBallPolicy, int price) {
        return Lotto.createLotto(lottoBallPolicy.getLottoNumber(Lotto.getMaxSize()), price);
    }

    public List<StatisticsNumber> matchedLottoCount(WinnigLotto winningLotto){
        List<StatisticsNumber> matchedCountList = new ArrayList<>();
        for (Lotto lotto : lottoList) {
            int count = lotto.equalsCount(winningLotto.getWinningLottoNumbers());
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

    public int getLottoPrice() {
        return lottoList.stream()
                .map(Lotto::getPrice)
                .findFirst()
                .orElse(0);
    }

    public int getLottoAllPrice() {
        return lottoList.stream()
                .map(Lotto::getPrice)
                .reduce(Integer::sum)
                .orElse(0);
    }

    public void addLottos(Lottos lottos){
        var lottoListForAdd = lottos.getLottoList();
        lottoList.addAll(lottoListForAdd);
    }
}
