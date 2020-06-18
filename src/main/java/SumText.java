public class SumText {
    private int sum = 0;
    private String[] text;

    public SumText(String[] text) {
        this.text = text;
    }

    public int sum() {
        for (String value : text) {
            sum += convertStringToInt(value);
        }
        return sum;
    }

    private int convertStringToInt(String string) {
        int castingValue = Integer.parseInt(string);

        if (castingValue < 0) {
            throw new RuntimeException();
        }
        return castingValue;
    }
}
