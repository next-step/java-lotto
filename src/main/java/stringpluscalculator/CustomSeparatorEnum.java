package stringpluscalculator;

public enum CustomSeparatorEnum {
    PREFIX("//"),
    SUFFIX("\\n");

    private String value;

    CustomSeparatorEnum(String value){
        this.value = value;
    }

    public static String searchCustomSeparator(String input) {
        int suffixIndex = input.indexOf(SUFFIX.value);

        return input.substring(PREFIX.value.length(), suffixIndex);
    }

    public static String withoutCustomSeparator(String input) {
        if (CustomSeparatorEnum.hasCustomSeparator(input)) {
            return input.substring(input.indexOf(SUFFIX.value) + SUFFIX.value.length());
        }
        return input;
    }

    public static boolean hasCustomSeparator(String input) {
        return input.startsWith(PREFIX.value) && input.indexOf(SUFFIX.value) > PREFIX.value.length();
    }
}
