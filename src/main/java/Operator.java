import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Queue;

public enum Operator {

    ADDITION("+") {
        @Override
        public void performOperation(Queue<String> queue, Number number) {
            Number fromQueue = Number.ofNumber(queue.poll());
            number.add(fromQueue);
        }
    }, SUBTRACTION("-") {
        @Override
        public void performOperation(Queue<String> queue, Number number) {
            Number fromQueue = Number.ofNumber(queue.poll());
            number.subtract(fromQueue);
        }
    }, MULTIPLICATION("*") {
        @Override
        public void performOperation(Queue<String> queue, Number number) {
            Number fromQueue = Number.ofNumber(queue.poll());
            number.multiple(fromQueue);
        }
    }, DIVISION("/") {
        @Override
        public void performOperation(Queue<String> queue, Number number) {
            Number fromQueue = Number.ofNumber(queue.poll());
            number.divide(fromQueue);
        }
    };

    private static final Map<String, Operator> SIGNATURE_OPERATOR_MAP = new HashMap<>();

    private String signature;

    Operator(String signature) {
        this.signature = signature;
    }

    static {
        for (Operator operator : Operator.values()) {
            SIGNATURE_OPERATOR_MAP.put(operator.signature, operator);
        }
    }

    public static Operator fromSignature(String signature) {
        return Optional.ofNullable(SIGNATURE_OPERATOR_MAP.get(signature))
                       .orElseThrow(() -> new IllegalArgumentException("입력값이 잘못되었습니다."));

    }

    public abstract void performOperation(Queue<String> queue, Number number);
}
