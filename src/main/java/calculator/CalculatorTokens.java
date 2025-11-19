package calculator;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CalculatorTokens {
    private Queue<String> calculateTokens;
    private final String firstTokenNum;

    public CalculatorTokens(List<String> calculateTokens) {
        if (calculateTokens.isEmpty()) {
            throw new IllegalArgumentException("계산토큰목록을 필수 입니다.");
        }

        this.calculateTokens = new LinkedList<>(calculateTokens);
        this.firstTokenNum = this.calculateTokens.poll();
    }

    public int firstTokenNum() {
        return Integer.parseInt(firstTokenNum);
    }

    public OneTokenBundle getOneTokenBundle() {
        if (calculateTokens.isEmpty()) {
            throw new RuntimeException("계산할 수 있는 토큰이 없습니다");
        }

        return new OneTokenBundle(
                calculateTokens.poll(),
                calculateTokens.poll()
        );
    }

    public boolean hasNext() {
        return !calculateTokens.isEmpty();
    }

}
