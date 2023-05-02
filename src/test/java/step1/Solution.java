package step1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Solution {
    Map<Character, Character> parenthesesPair = Map.of(
            '(', ')',
            '{', '}',
            '[', ']'
    );

    public boolean isValid(String s) {


        Stack<Character> characters = new Stack<>();

        for (char c : s.toCharArray()) {
            if (popWhenComplete(characters, c)) {
                continue;
            }
            characters.push(c);
        }
        return characters.isEmpty();
    }

    private boolean popWhenComplete(Stack<Character> characters, char c) {
        if (characters.size() < 1) {
            return false;
        }
        if (parenthesesPair.containsKey(characters.peek())) {
            if (c == parenthesesPair.get(characters.peek())) {
                characters.pop();
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean actual = solution.isValid("(]");
        boolean expect = true;
        System.out.println(actual == expect);
    }


    public int[] leftRigthDifference(int[] nums) {
        int[] actual = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            actual[i] = Math.abs(left(nums, i) - right(nums, i));
        }
        return actual;
    }

    private int left(int[] nums, int index) {
        if (index == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < index; i++) {
            sum += nums[i];
        }
        return sum;
    }

    private int right(int[] nums, int index) {
        if (index == (nums.length - 1)) {
            return 0;
        }
        int sum = 0;
        for (int i = index + 1; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }

    public String interpret(String command) {
        StringBuilder answerBuilder = new StringBuilder();
        char[] chars = command.toCharArray();
        for (int point = 0; point < chars.length; point++) {
            if (chars[point] == 'G') {
                answerBuilder.append('G');
                continue;
            }
            if (chars[point] == '(' && chars[point + 1] == ')') {
                answerBuilder.append('o');
                point++;
                continue;
            }
            if (chars[point] == '(' && chars[point + 1] == 'a') {
                answerBuilder.append("al");
            }
        }
        return answerBuilder.toString();
    }

    public int subtractProductAndSum(int n) {
        int sum = 0;
        int product = 1;
        for (char c : Integer.toString(n).toCharArray()) {
            sum += Character.getNumericValue(c);
            product *= Character.getNumericValue(c);
        }
        return product - sum;
    }

    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < index.length; i++) {
            numbers.add(index[i], nums[i]);
        }
        return numbers.stream().mapToInt(i -> i).toArray();
    }

    public int[] decode(int[] encoded, int first) {
        int[] numbers = new int[encoded.length + 1];
        numbers[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            numbers[i + 1] = numbers[i] ^ encoded[i];
        }
        return numbers;
    }
}
