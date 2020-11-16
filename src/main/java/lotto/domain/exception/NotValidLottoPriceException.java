package lotto.domain.exception;

public class NotValidLottoPriceException extends RuntimeException {

    private static final String MESSAGE = "원 만큼 더 필요합니다";

    public NotValidLottoPriceException(int insufficientAmount){
        super(insufficientAmount+MESSAGE);
    }
}
