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

    public static int[] makeNumberList(String input) {
        String[] string = input.split(",");
        int[] numbers = new int[string.length];
        for(int i = 0 ; i < numbers.length ; i++) {
            numbers[i] = StringUtils.returnNumber(input);
        }
        return numbers;
    }
//
//    public static int conversionString(String input) {
//        return Integer.parseInt(input);
//    }
//
//    public static int beforeConversion(String input) {
//        if(StringUtils.isNumeric(input)) {
//            conversionString(input);
//        }
//        return 0;
//    }
}
