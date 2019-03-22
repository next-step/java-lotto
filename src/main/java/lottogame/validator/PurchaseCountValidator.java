package lottogame.validator;

public class PurchaseCountValidator implements Validatable<Long> {

    private long count;

    public PurchaseCountValidator(long count) {
        this.count = count;
    }

    @Override
    public boolean isValid(Long target) {
        return count > 0 && count >= target;
    }

    @Override
    public String getInvalidMessage() {
        return "구매 개수가 잘못 입력되었습니다.";
    }
}