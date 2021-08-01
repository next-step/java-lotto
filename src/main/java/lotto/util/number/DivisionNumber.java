package lotto.util.number;

public final class DivisionNumber extends CalculationNumber {
    public DivisionNumber(Number leftNumber, Number rightNumber) {
        super(leftNumber, rightNumber);
    }

    @Override
    protected Integer calculateInteger(Number leftNumber, Number rightNumber) {
        return leftNumber.intValue() / rightNumber.intValue();
    }

    @Override
    protected Long calculateLong(Number leftNumber, Number rightNumber) {
        return leftNumber.longValue() / rightNumber.longValue();
    }

    @Override
    protected Float calculateFloat(Number leftNumber, Number rightNumber) {
        return leftNumber.floatValue() / rightNumber.floatValue();
    }

    @Override
    protected Double calculateDouble(Number leftNumber, Number rightNumber) {
        return leftNumber.doubleValue() / rightNumber.doubleValue();
    }
}
