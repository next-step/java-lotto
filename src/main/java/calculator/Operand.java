package calculator;

import java.util.ArrayList;
import java.util.List;

public class Operand {

    private final List<Integer> operands = new ArrayList<>();

    public Operand(List<String> parsingText) {
        this.setOperands(parsingText);
    }

    private void setOperands(List<String> parsingText) {
        parsingText.stream().forEach(this::insertOperand);
        this.operands.stream().filter(operand -> operand < 0)
                .findAny()
                .ifPresent(operand -> {
                    throw new RuntimeException("음수를 입력할 수 없습니다.");
                });
    }

    public List<Integer> getOperands() {
        return this.operands;
    }

    private void insertOperand(String slice) {
        try {
            int operand = Integer.parseInt(slice);
            this.operands.add(operand);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자 이외의 값이 입력되었습니다.");
        }
    }
}
