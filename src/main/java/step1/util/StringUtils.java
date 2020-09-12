package step1.util;

public class StringUtils {
    public static boolean isNotBlank(String input) {
        if(input == null || input.equals("")) {
            return true;
        }
        return false;
    }

    public static boolean isNumeric(String input) {
        try{
            Double.parseDouble(input);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    public static int returnNumber(String input) {
        if(isNotBlank(input)) {
            return 0;
        }
        return Integer.parseInt(input);
    }

    public static int[] makeNumberList(String[] stringNo) {
        int[] numbers = new int[stringNo.length];
        for(int i = 0 ; i < stringNo.length ; i++) {
            numbers[i] = StringUtils.returnNumber(stringNo[i]);
        }
        return numbers;
    }

}
