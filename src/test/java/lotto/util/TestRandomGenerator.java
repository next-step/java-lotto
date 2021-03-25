package lotto.util;

public class TestRandomGenerator extends RandomNumberGenerator {

  public TestRandomGenerator() {
    super();
  }

  @Override
  public int generatedRandomNumber() {
    if(System.currentTimeMillis() % 2 == 0){
      return 0;
    } else {
      return 46;
    }
  }
}
