package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lotto.domain.exception.LottoException;

public class Lotto {

    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        validation(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto(String numbers) {
        this(makeLottoNumbers(numbers));
    }

    private static List<LottoNumber> makeLottoNumbers(String numbers) {
        return Arrays.stream(numbers.split(", "))
            .map(LottoNumberFactory::getLottoNumber)
            .collect(Collectors.toList());
    }

    private void validation(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new LottoException("로또 번호는 6개여야 합니다.");
        }

        long count = lottoNumbers.stream()
            .distinct()
            .count();

        if (count != 6) {
            throw new LottoException("로또 번호는 중복될 수 없습니다.");
        }
    }

    public int winningNumberCount(Lotto winningNumber) {
        return (int) lottoNumbers.stream()
            .filter(ball -> agreementBall(winningNumber, ball) == 1)
            .count();
    }

    boolean hasLottoNumber(LottoNumber bonusBall) {
        List<LottoNumber> lottoNumberList = lottoNumbers.stream()
            .filter(numbers -> numbers.equals(bonusBall))
            .collect(Collectors.toList());
        return lottoNumberList.size() > 0;
    }

    private long agreementBall(Lotto winningNumber, LottoNumber lottoNumber) {
        return winningNumber.lottoNumbers.stream()
            .filter(winner -> winner.equals(lottoNumber))
            .count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    public List<LottoNumber> lotto() {
        return new ArrayList<>(lottoNumbers);
    }
}
