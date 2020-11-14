public class StringCalculator {
    public int sum(String text) {
        if(checkNullString(text) || checkEmptyString(text)) {
            return 0;
        }
        return 0;
    }

    private boolean checkEmptyString(String text) {
        return text.isEmpty();
    }

    private boolean checkNullString(String text) {
        return text == null;
    }

}
