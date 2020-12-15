package lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;
    private final static List<LottoNumber> initlottoNumber = IntStream.range(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER).boxed().map(LottoNumber::from).collect(Collectors.toList());
    public final List<LottoNumber> lottoNumbers;

    private Lotto() {
        lottoNumbers = autoGenerateLottoNumber();
    }

    private Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    private Lotto(LottoNumber[] lottoNumbers) {
        validLottoNumberCheck(lottoNumbers);
        this.lottoNumbers = Arrays.stream(lottoNumbers).collect(Collectors.toList());
    }

    private void validLottoNumberCheck(LottoNumber[] lottoNumbers) {
        if(lottoNumbers.length != 6){
            throw new IllegalStateException("로또번호가 올바르지 않습니다.");
        }
    }

    public static Lotto from(List<LottoNumber> lottoNumbers){
        return new Lotto(lottoNumbers);
    }

    public static Lotto from(){
        return new Lotto();
    }

    public static Lotto of(LottoNumber[] winnerLotto){
        return new Lotto(winnerLotto);
    }

    public List<LottoNumber> autoGenerateLottoNumber() {
        Collections.shuffle(initlottoNumber);
        return initlottoNumber.stream()
                .limit(6)
                .sorted(Comparator.comparing(LottoNumber::toInt))
                .collect(Collectors.toList());
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public boolean isContainLottoNumber(LottoNumber lottoNumber){
        return this.lottoNumbers.contains(lottoNumber);
    }

    public Integer judgeWinnerNumber(LottoNumber lottoNumber) {
        if(isContainLottoNumber(lottoNumber)){
            return 1;
        }
        return 0;
    }

}
