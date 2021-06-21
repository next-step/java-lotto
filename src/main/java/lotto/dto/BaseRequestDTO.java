package lotto.dto;


public abstract class BaseRequestDTO<E> {

    public abstract E toEntity();

    protected int parseIntElseThrow(final String textMoney, String errorMessage) {
        try {
            return Integer.parseInt(textMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
