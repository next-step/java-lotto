package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {

    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int LOTTO_SIZE = 6;
    private static final int THOUSAND = 1000;
    private static final List<Integer> LOTTO_NUMBERS = Stream.iterate(MIN_LOTTO_NUMBER, n -> n + 1).limit(MAX_LOTTO_NUMBER).collect(Collectors.toList());

    public List<Integer> lotto;

    public Lotto(List<Integer> lottoNumber) {
        validLottoNumberRange(lottoNumber);
        validLottoSize(lottoNumber);
        validDuplicatedLottoNumbers(lottoNumber);
        this.lotto = lottoNumber;
    }

    public static Lotto of(List<Integer> lottoNumbers) {
        Collections.sort(lottoNumbers);
        return new Lotto(new ArrayList<>(lottoNumbers));
    }

    public boolean containsBonusNumber(Integer bonusNumber) {
        return this.lotto.contains(bonusNumber);
    }

    public static Lotto createLottoNumber() {
        Collections.shuffle(LOTTO_NUMBERS);
        return LOTTO_NUMBERS.stream()
                .limit(6)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::of));
    }

    public static int getLottoCount(int payment) {
        validPrice(payment);
        return payment / THOUSAND;
    }

    public Integer getHitCount(Lotto winningLotto) {
        return winningLotto.lotto.stream().filter(lotto::contains)
                .map(e -> 1)
                .reduce(0, Integer::sum);
    }

    private void validLottoSize(List<Integer> lottoNumber) {
        if (lottoNumber.size() != Lotto.LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 여섯개를 입력해야 합니다.");
        }
    }

    private void validLottoNumberRange(List<Integer> lottoNumber) {
        Optional<Integer> overNumber = lottoNumber.stream()
                .filter(number -> number > Lotto.MAX_LOTTO_NUMBER || number < Lotto.MIN_LOTTO_NUMBER)
                .findAny();

        if (overNumber.isPresent()) {
            throw new IllegalArgumentException("로또 번호는 1이상 45 이하여야 합니다");
        }
    }

    private void validDuplicatedLottoNumbers(List<Integer> lottoNumbers) {
        boolean isDuplicate = lottoNumbers.stream()
                .distinct()
                .count() != lottoNumbers.size();
        if (isDuplicate) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    private static void validPrice(int payment) {
        if (payment < THOUSAND) {
            throw new IllegalArgumentException("로또 최소 구매 금액은 1000원 입니다");
        }
    }

    @Override
    public String toString() {
        return "" + lotto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }
}
