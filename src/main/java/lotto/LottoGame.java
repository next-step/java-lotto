package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoGame {

    public static final int LOTTO_PRICE = 1000;
    private List<Integer> lottoNumbers = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());

    public List<Lotto> buyLotto(int price, List<List<Integer>> numbers) {
        return buyAutoSelectedLottos(price, buyManualSelectLotto(numbers));
    }

    private List<Lotto> buyManualSelectLotto(List<List<Integer>> numbers) {
        return numbers.stream().map(Lotto::new)
                .collect(Collectors.toList());
    }

    private List<Lotto> buyAutoSelectedLottos(int price, List<Lotto> lottos) {
        List<Lotto> lottoList = new ArrayList<>(lottos);
        //자동 값 생성
        lottoList.addAll(Stream
                .generate(() -> new Lotto(makingLottoNumbers()))
                .limit(getGameCount(price, lottos.size()))
                .collect(Collectors.toList()));
        return lottoList;
    }

    private List<Integer> makingLottoNumbers() {
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.subList(0, 6);
    }

    private int getGameCount(int price, int count) {
        if (isValidBuyLottoPrice(price)) {
            throw new IllegalArgumentException();
        }
        int gameCount = price / LOTTO_PRICE - count;
        if (gameCount < 0) {
            throw new IllegalArgumentException();
        }
        return gameCount;
    }

    private boolean isValidBuyLottoPrice(int price) {
        return price % LOTTO_PRICE != 0;
    }


    public WinningLottoNumbers registerWinningLottoNumbers(List<Integer> lotto, Integer bonus) {
        return new WinningLottoNumbers(lotto, bonus);
    }


    public WinningLottos classifyRankLotto(List<Lotto> lottos, WinningLottoNumbers winningLottoNumbers) {
        LottoStatics lottoStatics = new LottoStatics();
        return lottoStatics.classifyRankLotto(lottos, winningLottoNumbers);
    }

}
