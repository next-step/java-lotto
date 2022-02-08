package lotto.domain;

public class Money {

    private final int value;

    public Money(final String value) {
        validateTypeLessThousand(value);
        validateTypeNegativeNumber(value);
        validateTypeInput(value);
        this.value = Integer.parseInt(value);
    }

    public Money(final int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    private void validateTypeLessThousand(String value) {
        System.out.println(value);
        if (Integer.parseInt(value) < 1000) {
            throw new IllegalArgumentException("구매 금액은 1000원 이하일 수 없습니다.");
        }
    }

    private void validateTypeNegativeNumber(String value) {
        if(Integer.parseInt(value) <0)
            throw new IllegalArgumentException("구매 금액은 음수일 수 없습니다.");
    }

    private int validateTypeInput(String value) {
        try {
            return Integer.parseInt(value);
        }catch(NumberFormatException exception){
            throw new IllegalArgumentException("구매 금액은 정수만 가능합니다. ");
        }
    }

}

