package StringAdder;

public class Adder {
    private final String rawInput;

    public Adder(String rawInput) {
        this.rawInput = rawInput;
    }

    public Num add() {
        Num result = new Num(0);

        if (inputIsNullOrEmpty()) {
            return result;
        }

        Spliterator spliterator = new Spliterator(rawInput);
        while (spliterator.hasNext()) {
            result = result.add(spliterator.next());
        }

        return result;
    }

    private boolean inputIsNullOrEmpty() {
        return rawInput == null || rawInput.isEmpty();
    }
}
