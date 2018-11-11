package lotto;

import lotto.utils.IGenerateLotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lotto {

    private static final int DEFAULT_MATCH_LOTTO_POINT = 0;

    private IGenerateLotto generateLotto;
    private LottoNumber lottoNumber;
    private int matchLottoPoint;

    public Lotto(final IGenerateLotto generateLotto) {
        this.generateLotto = generateLotto;
        this.lottoNumber = new LottoNumber();
        this.matchLottoPoint = DEFAULT_MATCH_LOTTO_POINT;
    }

    public void createLotto() {
        this.lottoNumber = new LottoNumber(this.generateLotto.create());
    }

    public void createLotto(final String lottoNumber) {
        this.lottoNumber = new LottoNumber(new ArrayList<>(convertInts(split(lottoNumber))));
    }

    public LottoNumber getLottoNumber() {
        return lottoNumber;
    }

    /**
     * 맞춘 로또 번호가 몇개인지 확인하기 전에
     * calculatorMatchLottoNumber() 로또 번호가 몇개 맞았는지 계산할 것.
     *
     * @param point int
     * @return boolean
     */
    public boolean isMatchPoint(final int point) {
        return this.matchLottoPoint == point;
    }

    public void calculatorMatchLottoNumber(final LottoNumber sourceLottoNumber) {
        for (Integer targetLottoNumber : this.getLottoNumber().getNumbers()) {
            lottoNumberLoop(sourceLottoNumber, targetLottoNumber);
        }
    }

    private void lottoNumberLoop(final LottoNumber sourceLottoNumber, final Integer targetLottoNumber) {
        for (Integer lottoNumber : sourceLottoNumber.getNumbers()) {
            checkLottoNumberSame(targetLottoNumber, lottoNumber);
        }
    }

    private void checkLottoNumberSame(final Integer sourceLottoNumber, final Integer targetLottoNumber) {
        if (sourceLottoNumber.equals(targetLottoNumber)) {
            this.matchLottoPoint++;
        }
    }

    private List<Integer> convertInts(final String[] lottoNumbers) {
        final List<Integer> ints = new ArrayList<>();
        for (String text : lottoNumbers) {
            ints.add(convertInt(text));
        }
        return ints;
    }

    private int convertInt(final String text) {
        return Integer.parseInt(text);
    }

    private String[] split(final String lottoNumbers) {
        return lottoNumbers.split(",");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return matchLottoPoint == lotto.matchLottoPoint &&
                Objects.equals(generateLotto, lotto.generateLotto) &&
                Objects.equals(lottoNumber, lotto.lottoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(generateLotto, lottoNumber, matchLottoPoint);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Lotto{");
        sb.append("generateLotto=").append(generateLotto);
        sb.append(", lottoNumber=").append(lottoNumber);
        sb.append(", matchLottoPoint=").append(matchLottoPoint);
        sb.append('}');
        return sb.toString();
    }

}
