package lotto.domain;

public class LottoNumberFactoryImpl implements LottoNumberFactory{
    @Override
    public Number generateNumber(Integer customNumber) {
        if (customNumber == null) {
            return new RandomNumber();
        }
        return new CustomNumber(customNumber);
    }
}
