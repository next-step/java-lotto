package stringCalculator;

public class ConditionValidation {
    public static boolean isBlank(String calcStr) {
        return calcStr == null || calcStr.isEmpty();
    }

    public static boolean isContainDelimiter(String calcStr) {
        return isDefaultDelimiter(calcStr) || isCustomDelimiter(calcStr);
    }

    public static boolean isDefaultDelimiter(String calcStr) {
        return calcStr.contains(",") || calcStr.contains(":");
    }

    private static boolean isCustomDelimiter(String calcStr) {
        return calcStr.matches("//(.)\n(.*)");
    }
}
