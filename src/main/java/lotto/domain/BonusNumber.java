package lotto.domain;

import lotto.util.NumberUtil;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class BonusNumber{

    private static final String NUMBER_EXIST_EXCEPTION = "Bonus Number exist in lastWinningNumber.";
    private Set<LottoNumber> lastWinningNumber;

    private LottoNumber bonusNumber;

    protected BonusNumber(){ }

    protected BonusNumber(int newbonusNumber){
        this.bonusNumber = new LottoNumber( newbonusNumber);
    }

    public BonusNumber(String lastWinningNumber, String newbonusNumber) {
        this.lastWinningNumber = generateLastWinningNumbers(lastWinningNumber);
        this.bonusNumber = generateBonusNumber(newbonusNumber);
        validBonusNumber(this.lastWinningNumber, this.bonusNumber);
    }

    protected Set<LottoNumber> generateLastWinningNumbers(String lastWinningNumber) {
        List<Integer> lastWinningNumbers = NumberUtil.convertStringToIntegerList(lastWinningNumber);
        Set<LottoNumber> lastWinningNumberSet = convertLottoNumberSet(lastWinningNumbers);
        return lastWinningNumberSet;
    }

    protected void validBonusNumber(Set<LottoNumber> lastWinningNumber, LottoNumber newbonusNumber) {
        boolean duplicateBonusNumber = lastWinningNumber.contains(newbonusNumber);
        if(duplicateBonusNumber == true){
            throw new IllegalArgumentException(NUMBER_EXIST_EXCEPTION);
        }
    }

    protected Set<LottoNumber> convertLottoNumberSet(List<Integer> lastWinningNumbers) {
        Set<LottoNumber> lastWinningNumberSet = lastWinningNumbers.stream()
                .map(LottoNumber::new).collect(Collectors.toSet());
        return lastWinningNumberSet;
    }
    protected LottoNumber generateBonusNumber(String newbonusNumber){
        int inputBonusNumber = NumberUtil.convertStringToInteger(newbonusNumber);
        return new LottoNumber(inputBonusNumber);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BonusNumber)) return false;
        BonusNumber that = (BonusNumber) o;
        return bonusNumber.equals(that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bonusNumber.atomicNumber());
    }

    public LottoNumber getLottoNumber() {
        return this.bonusNumber;
    }
}

