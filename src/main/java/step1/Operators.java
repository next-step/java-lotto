package step1;

import java.util.LinkedList;
import java.util.Queue;

public class Operators {
    private Queue<String> operators = new LinkedList<>();

    public void add(String input) {
        operators.add(input);
    }

    public String peek() {
        return operators.poll();
    }
}
