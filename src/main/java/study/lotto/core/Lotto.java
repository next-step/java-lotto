package study.lotto.core;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    public static final int PRICE_PER_LOTTO = 1000;
    public static final int LOTTO_NUMBER_COUNT = 6;

    private final List<LottoNumber> lottoNumbers;
    private LottoStatus lottoStatus;

    public Lotto(List<LottoNumber> lottoNumbers) {

        this.lottoNumbers = Optional.ofNullable(lottoNumbers)
                .orElse(new ArrayList<>());
        throwIfNumberCountNotMatch();

        this.lottoStatus = LottoStatus.BEFORE_LOTTERY;

        sortLottoNumbers();
    }

    private void throwIfNumberCountNotMatch() {
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 6개를 입력해주세요.");
        }
    }

    private void sortLottoNumbers() {
        Collections.sort(lottoNumbers);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public WinningLotto lottery(WinLottoNumbers winLottoNumbers) {

        if (this.lottoStatus == LottoStatus.HAS_BEEN_LOTTERY) {
            throw new IllegalArgumentException("이미 추첨한 로또입니다.");
        }

        this.lottoStatus = LottoStatus.HAS_BEEN_LOTTERY;

        List<LottoNumber> lottoNumbers = Optional.ofNullable(winLottoNumbers)
                .map(w -> w.matchWithWinLottoNumbers(this))
                .orElse(new ArrayList<>());

        boolean matchWithBonusLottoNumber = Optional.ofNullable(winLottoNumbers)
                .map(w -> w.matchWithBonusLottoNumber(this))
                .orElse(false);

        return new WinningLotto(lottoNumbers, matchWithBonusLottoNumber);
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

}
