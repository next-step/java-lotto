public class InputView {
    public static String[] splitByEmptyString(String input) {
        if(input == null || input.replaceAll(" ", "").isEmpty()){
            throw new IllegalArgumentException("input must not empty string");
        }
        if(!input.replaceAll(" ","").replaceAll("[0-9]","").matches("[+\\-*/\\s]+")){
            throw new IllegalArgumentException("input must contain arithmetic characters");
        }
        return input.split(" ");
    }
}
