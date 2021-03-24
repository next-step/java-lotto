# 기능 정의

<!-- - ## ConstructorStragy.java / interface
  - List<Integer> constructor();
- ## AutoNumber.java / extends ConstructorStragy
  - List<Integer> constructor(); -->

- ## Lotto.java
  - field
    - List<Integer> lotto;
  - constructor
    - Lotto();
      - 자동생성, random 6 자리 생성
    - Lotto(List<Integer> numbers);
      - 수동생성
  - method
    - void check();
      - redirect to check(List<Integer> lotto);
    - void check(List<Integer> lotto);
      - 6자리의 숫자가 맞는지
      - 45를 넘어가는 숫자가 없는지
      - 동일한 숫자가 없는지
      <!-- - List<Integer> lottoNumbers(AutoNumber autoNumber); -->
    - int match(List<Integer> winningNumber);
      - 당첨번호와 맞춰본후 등수를 return;
- ## Lottos.java
  - field
    - List<Lotto> lottos;
  - constructor
    - Lottos(int money);
      - 돈을 받고, lotto list 생성
  - method
    - Iterator<List<Integer>> lottos();
      - 구매한 lotto 번호를 확인하기 위해, list return
      - 이부분은 return 값을 iterator 로 구현해볼 예정
    - List<Integer> match(List<Integer> numbers);
      - 당첨번호를 받아서, 등수 list 를 return
    - List<Integer> lottoNumbers();
      - 로또 숫자 6자리 생성
      - set 으로 생성해서 동일한 숫자가 안겹치도록
