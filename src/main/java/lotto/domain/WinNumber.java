package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class WinNumber {

    private static final int INIT_BONUS = 0;

    private final LottoNumbers winNumbers;
    private BonusNumber bonus;

    public WinNumber(String[] numbers) {
        List<LottoNumber> toLottoNumber = Arrays.stream(numbers)
            .map(Integer::parseInt)
            .map(LottoNumber::new)
            .collect(Collectors.toList());

        this.winNumbers = new LottoNumbers(toLottoNumber);
    }

    public WinNumber(Integer... numbers) {
        this(new LottoNumbers(numbers));
    }

    public WinNumber(LottoNumbers winNumbers) {
        this(winNumbers, new BonusNumber(INIT_BONUS));
    }

    public WinNumber(LottoNumbers winNumbers, BonusNumber bonus) {
        this.winNumbers = winNumbers;
        this.bonus = bonus;
    }

    public Rank calculateRank(TreeSet<LottoNumber> lottoNumbers) {
        boolean isMatchBonus = isMatchBonus(lottoNumbers);

        int matchCount = 0;
        for (LottoNumber lottoNumber : lottoNumbers) {
            matchCount = winNumbers.contains(lottoNumber) ? matchCount + 1 : matchCount;
        }

        return Rank.match(matchCount, isMatchBonus);
    }

    public void addBonus(BonusNumber bonus) {
        if (winNumbers.contains(bonus.toLottoNumber())) {
            throw new IllegalArgumentException();
        }
        this.bonus = bonus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof WinNumber))
            return false;
        WinNumber winNumber = (WinNumber)o;
        return Objects.equals(winNumbers, winNumber.winNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(winNumbers);
    }

    private boolean isMatchBonus(TreeSet<LottoNumber> lottoNumbers) {
        return lottoNumbers.contains(bonus.toLottoNumber());
    }
}
