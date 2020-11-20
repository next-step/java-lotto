package step1.addCalculator.util;

public class CommonValueCheck {

    public static Integer valueCheck(String paramValue) {
        return isNegative(isNumber(paramValue));
    }

    private static Integer isNegative(Integer paramValue) {
        if (paramValue < 0) {
            throw new RuntimeException(ErrorMessage.getNEGATIVEEXCEPTION());
        }

        return paramValue;
    }

    private static Integer isNumber(String paramValue) {
        try {
            return Integer.parseInt(paramValue);
        } catch (NumberFormatException e) {
            System.out.println(e.toString() + " : " + ErrorMessage.getNUMBERFORMATEXCEPTION());
        }

        return Integer.parseInt(paramValue);
    }
}
