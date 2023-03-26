package lotto.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_NUMBER_COUNT = 6;

    private List<LottoNumber> lottoNumbers;

    public Lotto(int... numbers) {
        this(Arrays.stream(numbers)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList()));
    }

    public Lotto(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호 개수는 6개 이여야 함");
        }

        if (lottoNumbers.stream().distinct().count() < LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("중복 번호 존재");
        }

        Collections.sort(lottoNumbers, (a, b) -> a.getValue() - b.getValue());
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    public int match(WinningLotto winningLotto) {

        int hitCount = (int) lottoNumbers.stream()
                .filter(it -> winningLotto.getLotto().getLottoNumbers().contains(it))
                .count();

        if (hitCount == 6) {
            return 1;
        }

        boolean hitBonus = lottoNumbers.contains(winningLotto.getBonusNumber());
        if (hitCount == 5 && hitBonus) {
            return 2;
        }

        if (hitCount > 2) {
            return 6 - hitCount + 2;
        }

        return 0;
=======
import java.util.List;

public class Lotto {

    private long purchaseAmount;

    private List<LottoNumber> lottoNumbers;

    public Lotto(long purchaseAmount, List<LottoNumber> lottoNumbers) {
        this.purchaseAmount = purchaseAmount;
        this.lottoNumbers = lottoNumbers;
    }

    public void printToLottoNumber() {
        lottoNumbers.forEach(it -> System.out.println(it.printNumber()));
    }

    public void confirmWinningNumber(List<Integer> winningNumbers,
                                     int bonusNumber) {
        // 일반 볼 당첨 확인
        lottoNumbers.forEach(it -> it.setLevel(Level.hitCount(getHitCount(it, winningNumbers, bonusNumber))));

        // 보너스 볼 당첨 확인
        lottoNumbers.stream()
                .filter(it -> it.getLevel().equals(Level.SECOND) && it.getNumbers().contains(bonusNumber))
                .forEach(it -> it.setLevel(Level.BONUS));
    }

    public long getHitCount(LottoNumber lottoNumber,
                                List<Integer> winningNumbers,
                                int bonusNumber) {
        return lottoNumber.getNumbers()
                .stream()
                .filter(it -> winningNumbers.contains(it))
                .count();
    }

    public double getTotAteOfReturn() {
        long winningAmount = lottoNumbers.stream()
                .map(it -> it.getWinningAmount())
                .reduce(0L, Long::sum);

        return Math.round(((double) winningAmount / purchaseAmount) * 100) / 100.0;
    }

    public void printToResultWinning() {
        System.out.println("3개 일치 (" + Level.FOURTH.getAmount() + ")- " + getWinningCount(Level.FOURTH) + "개");
        System.out.println("4개 일치 (" + Level.THIRD.getAmount() + ")- " + getWinningCount(Level.THIRD) + "개");
        System.out.println("5개 일치 (" + Level.SECOND.getAmount() + ")- " + getWinningCount(Level.SECOND) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (" + Level.BONUS.getAmount() + ")- " + getWinningCount(Level.BONUS) + "개");
        System.out.println("6개 일치 (" + Level.FIRST.getAmount() + ")- " + getWinningCount(Level.FIRST) + "개");
    }

    private long getWinningCount(Level level) {
        return lottoNumbers.stream()
                .filter(it -> it.getLevel().equals(level))
                .count();
    }

    public void printToTotAteOfReturn() {
        System.out.println("총 수익률 " + getTotAteOfReturn() + "입니다.");
    }
}
