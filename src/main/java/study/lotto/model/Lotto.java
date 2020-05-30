package study.lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final List<LottoNumber> LOTTO_NUMBER_BASE = new ArrayList<>();
    private static final int LOTTO_NUMBERS_SIZE = 6;

    // 당첨 번호와 동일한 번호 보유 개수에 따른 당첨금 배열
    private static final int[] MATCH_PRIZES = new int[] { 0, 0, 0, 5000, 50000, 1500000, 2000000000 };

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

        return LOTTO_NUMBER_BASE.subList(0, 6);
    }

    public long compareToWinningNumbers(Lotto winningLotto) {
        return lottoNumbers.stream().filter(winningLotto.getLottoNumbers()::contains).count();
    }

    public int getPrize(Lotto winningLotto) {
        return MATCH_PRIZES[(int)compareToWinningNumbers(winningLotto)];
    }
}
