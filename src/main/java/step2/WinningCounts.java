package step2;

public class WinningCounts {

  private int first;
  private int second;
  private int third;
  private int fourth;
  private int fifth;

  private WinningCounts(Builder builder) {
    this.first = builder.first;
    this.second = builder.second;
    this.third = builder.third;
    this.fourth = builder.fourth;
    this.fifth = builder.fifth;
  }

  public int getFirst() {
    return first;
  }

  public int getSecond() {
    return second;
  }

  public int getThird() {
    return third;
  }

  public int getFourth() {
    return fourth;
  }

  public int getFifth() {
    return fifth;
  }

  public static class Builder {
    private int first;
    private int second;
    private int third;
    private int fourth;
    private int fifth;

    public Builder() {
      this.first = 0;
      this.second = 0;
      this.third = 0;
      this.fourth = 0;
      this.fifth = 0;
    }

    public Builder first(int first) {
      this.first = first;

      return this;
    }

    public Builder second(int second) {
      this.second = second;

      return this;
    }

    public Builder third(int third) {
      this.third = third;

      return this;
    }

    public Builder fourth(int fourth) {
      this.fourth = fourth;

      return this;
    }

    public Builder fifth(int fifth) {
      this.fifth = fifth;

      return this;
    }

    public WinningCounts build() {
      return new WinningCounts(this);
    }
  }  // ended of WinningCounts$Builder

}

