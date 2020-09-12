package step1.util;

public class Pattern {
    public static int[] containsDelimeter(String[] string) {
        int[] numbers = new int[string.length];
        for(int i = 0 ; i < numbers.length ; i++) {
            if(StringUtils.isNumeric(string[i])) {
                numbers[i] = Integer.parseInt(string[i]);
            }
        }
        return numbers;
    }


}
