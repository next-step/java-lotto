package step2.utils;

public class Conversion {

    private Conversion() {
    }

    public static int stringToInt(String str){
        return getStringToNumber(str);
    }

    private static int getStringToNumber(String str) {
        try {
            return Integer.parseInt(str);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
