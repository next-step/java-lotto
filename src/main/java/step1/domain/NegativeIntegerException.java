package step1.domain;

public class NegativeIntegerException extends RuntimeException {
    private int number;

    public NegativeIntegerException(int number) {
        super();
        this.number = number;
    }

    public NegativeIntegerException(String message, int number) {
        super(message);
        this.number = number;
    }

    public NegativeIntegerException(Throwable cause, int number) {
        super(cause);
        this.number = number;
    }

    public NegativeIntegerException(String message, Throwable cause, int number) {
        super(message, cause);
        this.number = number;
    }

    @Override
    public String getMessage() {
        return String.format("%s %d", super.getMessage(), number);
    }
}
