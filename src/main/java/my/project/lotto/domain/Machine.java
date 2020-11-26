package my.project.lotto.domain;

import my.project.constants.Rule;

import java.util.Collections;
import java.util.Stack;


/**
 * Created : 2020-11-23 오후 2:30
 * Developer : Seo
 */
public class Machine {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 1;
    private final Stack<Integer> numbers;

    public Machine() {
        numbers = new Stack<>();
        for (int i = MIN_NUMBER; i < MAX_NUMBER + 1; i++) {
            numbers.push(i);
        }
        Collections.shuffle(numbers);
    }

    public int pop() {
        return numbers.pop();
    }
}
