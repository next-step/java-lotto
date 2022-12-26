package lotto.domain;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class WinningNumbers {

    private static final String NULL_EXCEPTION_MESSGAE = "빈값이 들어왔습니다.";
    private static final String WINNING_NUMBER_EXCEPTION_MESSAGE = "당첨 번호는 6개만 입력해주세요.";
    private static final String BONUSNUMBER_EXCEPTION = "이미 당첨번호에 포함 되어 있습니다.";
    private static final int BONUS_MATCH_COUNT = 4;

    private final Set<LottoNumber> winningNumbers;
    private final LottoNumber bonusNumber;


    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber){
        validationListBlank(winningNumbers);
        validationNumbersSizeCheck(winningNumbers);
        this.winningNumbers = valueOf(winningNumbers);
        validationBonusNumberCheck(bonusNumber);
        this.bonusNumber = LottoNumber.of(bonusNumber);
    }

    private Set<LottoNumber> valueOf(List<Integer> winningNumbers){
        return winningNumbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toSet());
    }

    public boolean bonusNumberMatch(Set<LottoNumber> lottoTicket){
        int count = lottoMatchCount(lottoTicket);
        if(count == BONUS_MATCH_COUNT){
            return lottoTicket.contains(bonusNumber);
        }
        return false;
    }

    public int lottoMatchCount(Set<LottoNumber> lottoTicket){
        return (int) lottoTicket.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public Reward winningLottoMatch(Set<LottoNumber> lottoTicket){
        return Reward.rewardMatchCount(lottoMatchCount(lottoTicket), bonusNumberMatch(lottoTicket));
    }

    private void validationListBlank(List<Integer> winningNumbers){
        if(winningNumbers.isEmpty()){
            throw new NullPointerException(NULL_EXCEPTION_MESSGAE);
        }
    }

    private void validationNumbersSizeCheck(List<Integer> winningNumbers){
        if(winningNumbers.size() > 6){
            throw new IllegalArgumentException(WINNING_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    private void validationBonusNumberCheck(int bonusNumber){
        if(winningNumbers.contains(LottoNumber.of(bonusNumber))){
            throw new IllegalArgumentException(BONUSNUMBER_EXCEPTION);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningNumbers that = (WinningNumbers) o;
        return Objects.equals(winningNumbers, that.winningNumbers) && Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumbers, bonusNumber);
    }
}
