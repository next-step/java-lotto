package lotto.model;

import java.util.List;

public class Lotto {

    final private long purchaseAmount;

    final private List<LottoNumber> lottoNumbers;

    public Lotto(long purchaseAmount, List<LottoNumber> lottoNumbers) {
        this.purchaseAmount = purchaseAmount;
        this.lottoNumbers = lottoNumbers;
    }

    public void printToLotto() {
        lottoNumbers.stream()
                .forEach(it -> System.out.println(it.printNumber()));
    }

    public void confirmWinningNumber(List<Integer> winningNumbers,
                                     int bonusNumber) {
        // 일반 볼 당첨 확인
        lottoNumbers.stream()
                .forEach(it -> it.setLevel(Level.valueOf(getHitCount(it, winningNumbers))));

        // 보너스 볼 당첨 확인
        lottoNumbers.stream()
                .filter(it -> it.getLevel().equals(Level.SECOND) && it.getNumbers().contains(bonusNumber))
                .forEach(it -> it.setLevel(Level.BONUS));
    }

    public long getHitCount(LottoNumber lottoNumber,
                            List<Integer> winningNumbers) {
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
        System.out.println("3개 일치 (" + Level.FOURTH.getAmount() + ") : " + getWinningCount(Level.FOURTH) + "개");
        System.out.println("4개 일치 (" + Level.THIRD.getAmount() + ") : " + getWinningCount(Level.THIRD) + "개");
        System.out.println("5개 일치 (" + Level.SECOND.getAmount() + ") : " + getWinningCount(Level.SECOND) + "개");
        System.out.println("보너스볼 일치 + 5개 일치 (" + Level.BONUS.getAmount() + ") : " + getWinningCount(Level.BONUS) + "개");
        System.out.println("6개 일치 (" + Level.FIRST.getAmount() + ") : " + getWinningCount(Level.FIRST) + "개");
    }

    private long getWinningCount(Level level) {
        return lottoNumbers.stream()
                .filter(it -> it.getLevel().equals(level))
                .count();
    }

    public void printToTotAteOfReturn() {
        System.out.println("당첨통계 결과는" + getTotAteOfReturn() + "입니다.");
    }
}