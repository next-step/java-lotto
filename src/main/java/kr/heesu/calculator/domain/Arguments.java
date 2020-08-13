package kr.heesu.calculator.domain;

import java.util.List;

public class Arguments {
    private List<Integer> args;

    private Arguments(List<Integer> nums) {
        this.args = nums;
    }

    public boolean hasNext() {
        return !args.isEmpty();
    }

    public int nextArgument() {
        return this.args.remove(0);
    }

    public static Arguments of(List<Integer> nums) {
        return new Arguments(nums);
    }
}
