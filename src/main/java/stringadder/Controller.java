package stringadder;

public class Controller {
    public static void main(String[] args) {
        String input = "1,2,3";
        // convert and validate
        Validator val = new Validator(input);
        String[] validatedString = val.validate();
        // calucate
        StringAdder sa = new StringAdder(validatedString);
        int result = sa.add();

        System.out.println("더한 결과 : " + result);
    }
}
