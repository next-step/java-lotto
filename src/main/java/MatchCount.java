public class MatchCount {
    private int value;

    public MatchCount() {
        this(0);
    }

    public MatchCount(int value) {
        this.value = value;
    }

    public void tryIncrement(boolean matched) {
        if(matched){
            this.value++;
        }
    }


    @Override
    public boolean equals(Object obj) {
        return this.value == ((MatchCount) obj).value;
    }

    public boolean is(int num) {
        return this.value == num;
    }
}
