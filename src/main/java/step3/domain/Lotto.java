package step3.domain;

import java.util.*;

public class Lotto {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static final int SELECT_NUMBER = 6;
    private Set<LottoNumber> lottoList = new HashSet<>();

    public Lotto() {
        getLottoNumberList();
    }

    public void getLottoNumberList() {
        for (int i = LOTTO_START_NUMBER; i <= LOTTO_END_NUMBER; i++) {
            lottoList.add(new LottoNumber(i));
        }
        this.lottoList = lottoList;
    }

    public List<LottoNumber> getRandomLottoList() {
        List<LottoNumber> lottoList = new ArrayList(this.lottoList);
        Collections.shuffle(lottoList);
        List<LottoNumber> randomLottolList = new ArrayList<>(lottoList.subList(0, SELECT_NUMBER));
        Collections.sort(randomLottolList);
        return randomLottolList;
    }
}
