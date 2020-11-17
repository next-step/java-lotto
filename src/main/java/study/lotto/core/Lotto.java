package study.lotto.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Lotto {

    public static final int PRICE_PER_LOTTO = 1000;
    public static final int LOTTO_NUMBER_COUNT = 6;

    protected final List<LottoNumber> lottoNumbers;
    protected LottoStatus lottoStatus;

    public Lotto(List<LottoNumber> lottoNumbers) {

        this.lottoNumbers = lottoNumbers;
        sortLottoNumbers();

        this.lottoStatus = LottoStatus.BEFORE_LOTTERY;

        throwIfNumberCountNotMatch();
    }

    protected void throwIfNumberCountNotMatch() {
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 6개를 입력해주세요.");
        }
    }

    private void sortLottoNumbers() {
        Collections.sort(lottoNumbers);
    }

    protected boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public WinningLotto lottery(WinLottoNumbers winLottoNumbers) {

        if (this.lottoStatus == LottoStatus.HAS_BEEN_LOTTERY) {
            throw new IllegalArgumentException("이미 추첨한 로또입니다.");
        }

        this.lottoStatus = LottoStatus.HAS_BEEN_LOTTERY;
        return new WinningLotto(winLottoNumbers.match(this));
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        String lottoNumbersString = lottoNumbers.stream()
                .map(LottoNumber::toString)
                .collect(Collectors.joining(", "));

        stringBuilder.append(lottoNumbersString);
        stringBuilder.append("]");

        return stringBuilder.toString();
    }

}
