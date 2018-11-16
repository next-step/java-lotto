package util;

import domain.LottoAmount;
import domain.LottoNo;
import domain.Money;

import java.util.List;

import static domain.Lotto.isExistDuplicateNumber;
import static domain.LottoAmount.isAmountPositive;
import static domain.LottoNo.MAX_NUMBER;
import static domain.LottoNo.MIN_NUMBER;
import static domain.LottoWinning.isContainSameNumber;
import static domain.Money.isMoneyPositive;
import static domain.RandomNumberGenerator.LOTTO_DIGITS;

public class Validation {


    public static void validatePurchaseMoney(Money money){
        if(!isMoneyPositive(money))
            throw new RuntimeException("구입금액이 올바르게 입력되지 않았습니다.");
    }

    public static void validatePurchaseAmount(LottoAmount amount){
        if(!isAmountPositive(amount))
            throw new RuntimeException("로또 수가 올바르게 입력되지 않았습니다.");
    }

    public static void validateLottoNo(int number){
        if(MIN_NUMBER > number || MAX_NUMBER < number)
            throw new RuntimeException("로또 번호가 올바르게 입력되지 않았습니다.");
    }

    public static void validateLottoNos(List<LottoNo> numbers){
        if(numbers.size() != LOTTO_DIGITS)
            throw new RuntimeException("로또번호가 올바르지 않습니다.");

        if(isExistDuplicateNumber(numbers))
            throw new RuntimeException("로또번호는 중복일 수 없습니다.");
    }

    public static void validateBonusNo(List<LottoNo> winnerNumbers, LottoNo bonusNumber){
        if(isContainSameNumber(winnerNumbers, bonusNumber))
            throw new RuntimeException("보너스 번호는 중복일 수 없습니다.");
    }

}
