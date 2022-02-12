package lotto.domain;

public class LottoTicket {

    private final int value;

    public LottoTicket(final String value, final int count) {
        int convertIntValue = validateTypeInput(value);
        validateNegativeNumber(convertIntValue);
        validatePurchaseLottoTicketMax(convertIntValue, count);
        this.value = convertIntValue;
    }

    private void validatePurchaseLottoTicketMax(final int value, final int count){
        if(value>count)
            throw new IllegalArgumentException("로또 수는 구입 금액 범위 안에서 입력해주세요.");
    }

    private void validateNegativeNumber(final int value){
        if(value < 0){
            throw new IllegalArgumentException("수동으로 구매할 로또 수는 음수일 수 없습니다.");
        }
    }

    private int validateTypeInput(final String value){
        try{
            return Integer.parseInt(value);
        }catch (NumberFormatException exception){
            throw new IllegalArgumentException("수동으로 입력할 수 있는 로또 수는 정수만 작성할 수 있습니다.");
        }
    }

    public int getLottoTicketValue(){
        return value;
    }
}
