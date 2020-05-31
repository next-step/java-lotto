package study.lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final List<LottoNumber> LOTTO_NUMBER_BASE = new ArrayList<>();
    private static final int LOTTO_NUMBERS_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    static {
        for(int i=1; i<46; i++) {
            LOTTO_NUMBER_BASE.add(new LottoNumber(i));
        }
    }

    public Lotto(List<LottoNumber> lottoNumbers) {
        if(lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또는 6개의 숫자로 구성 되어야 합니다.");
        }

        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto generate() {
        Lotto lotto = new Lotto(generateLottoNumbers());
        Collections.sort(lotto.getLottoNumbers());

        return lotto;
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    private static List<LottoNumber> generateLottoNumbers() {
        Collections.shuffle(LOTTO_NUMBER_BASE);

        return new ArrayList<>(LOTTO_NUMBER_BASE.subList(0, 6));
    }

    public long compareToWinningNumbers(Lotto winningLotto) {
        return lottoNumbers.stream().filter(winningLotto.getLottoNumbers()::contains).count();
    }

    public LottoRank getPrize(Lotto winningLotto) {
        return LottoRank.find((int)compareToWinningNumbers(winningLotto));
    }

    public String toString() {
        return lottoNumbers.stream().map(LottoNumber::getNumber).collect(Collectors.toList()).toString();
    }
}
