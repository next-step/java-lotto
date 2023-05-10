package step1;

import java.util.LinkedList;
import java.util.Queue;

public class Formula {

    public static final String SEPARATOR = " ";
    private Queue<String> formula;

    public Formula(String ex) {
        validationCheck(ex);
        this.formula = textToQueue(ex);
    }

    private void validationCheck(String ex) {
        if(ex == null || ex.isEmpty()){
            throw new IllegalArgumentException("잘못된 입력값입니다.");
        }
    }

    private static Queue<String> textToQueue(String ex) {
        String[] split = ex.split(SEPARATOR);

        Queue<String> queue = new LinkedList<>();
        for (String s : split) {
            queue.add(s);
        }
        return queue;
    }

    public String poll() {
        return this.formula.poll().trim();
    }

    public String peek() {
        return this.formula.peek();
    }

    public Integer pollNumber() {
        return Integer.parseInt(this.formula.poll());
    }

}
