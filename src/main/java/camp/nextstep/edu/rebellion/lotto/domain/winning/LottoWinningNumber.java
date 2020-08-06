package camp.nextstep.edu.rebellion.lotto.domain.winning;

import camp.nextstep.edu.rebellion.lotto.domain.ticket.LottoNumber;
import camp.nextstep.edu.rebellion.lotto.util.StringUtil;

import java.util.List;
import java.util.stream.Collectors;

public class LottoWinningNumber {
    private List<LottoNumber> numbers;
    private LottoNumber bonus;

    public LottoWinningNumber(String inputNumbers, int bonusNumber) {
        this.numbers = generateWinningNumbers(inputNumbers);
        this.bonus = new LottoNumber(bonusNumber);
    }

    public boolean contain(LottoNumber number) {
        return this.numbers
                .stream()
                .anyMatch(lottoNumber -> lottoNumber.equals(number));
    }

    public boolean containBonus(LottoNumber number) {
        return this.bonus.equals(number);
    }

    private List<LottoNumber> generateWinningNumbers(String inputNumbers) {
        return StringUtil.convertList(inputNumbers)
                .stream()
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }
}
