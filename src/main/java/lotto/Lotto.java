package lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;
    private final List<LottoNumber> initlottoNumber = IntStream.range(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER).boxed().map(LottoNumber::from).collect(Collectors.toList());
    public final List<LottoNumber> lottoNumbers;

    private Lotto(boolean auto) {
        if(auto){
            lottoNumbers = autoGenerateLottoNumber();
        }else{
        // 수동입력 추후 구현
            lottoNumbers = new ArrayList<>();
        }

    }

    private Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    private Lotto(LottoNumber[] winnerLotto) {
        this.lottoNumbers = Arrays.stream(winnerLotto).collect(Collectors.toList());
    }

    public static Lotto from(List<LottoNumber> lottoNumbers){
        return new Lotto(lottoNumbers);
    }

    public static Lotto from(boolean auto){
        return new Lotto(auto);
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
        return this.lottoNumbers.stream().filter(n -> n.toString().equals(lottoNumber.toString())).findFirst().isPresent();
    }

    public Integer judgeWinnerNumber(LottoNumber lottoNumber) {
        if(isContainLottoNumber(lottoNumber)){
            return 1;
        }
        return 0;
    }

}
