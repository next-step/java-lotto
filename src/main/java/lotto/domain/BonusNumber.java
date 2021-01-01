package lotto.domain;

import lotto.util.NumberUtil;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BonusNumber extends LottoNumber{

    private static final String NUMBER_EXIST_EXCEPTION = "Bonus Number exist in lastWinningNumber.";

    protected BonusNumber(int bonusNumber){
        super(bonusNumber);
    }

    public BonusNumber(String lastWinningNumber, String newbonusNumber) {
        super(NumberUtil.convertStringToInteger(newbonusNumber));
        validBonusNumber(lastWinningNumber, newbonusNumber);
    }

    protected int validBonusNumber(String lastWinningNumber, String newbonusNumber){
        int inputBonusNumber = NumberUtil.convertStringToInteger(newbonusNumber);
        BonusNumber bonusNumber = new BonusNumber(inputBonusNumber);

        List<Integer> lastWinningNumbers = NumberUtil.convertStringToIntegerList(lastWinningNumber);
        Set<LottoNumber> lastWinningNumberSet = lastWinningNumbers.stream()
                .map(LottoNumber::new).collect(Collectors.toSet());

        boolean duplicateBonusNumber = lastWinningNumberSet.contains(bonusNumber);
        if(duplicateBonusNumber == true){
            throw new IllegalArgumentException(NUMBER_EXIST_EXCEPTION);
        }
        return inputBonusNumber;
    }
}

