import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private List<LottoNumber> lottoNumbers;
    private static final int LOTTOSIZE = 6;


    private Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto defaultOf() {
        List<LottoNumber> lottoNumbers =  new ArrayList<>();
        for (int i = 0; i < LOTTOSIZE; i++) {
            LottoNumber lottoNumber = LottoNumber.defaultOf();
            lottoNumbers.add(lottoNumber);
        }
        return new Lotto(lottoNumbers);
    }
    public static Lotto defaultOf(List<LottoNumber> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public int size() {
        return this.lottoNumbers.size();
    }

    public int howManySameNumber(Lotto lotto) {
        int sameNumberCount = 0;
        for (LottoNumber lottoNumber : this.lottoNumbers) {
            if (lotto.hasNumber(lottoNumber)) {
                sameNumberCount++;
            }
        }
        return sameNumberCount;
    }

    private boolean hasNumber(LottoNumber comparingLottoNumber) {
        return this.lottoNumbers.stream()
                .anyMatch(lottoNumber -> comparingLottoNumber.equals(lottoNumber));
    }
}
