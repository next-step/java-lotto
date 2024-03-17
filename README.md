# STEP 2 : 로또 (자동)

## ✅ 구현 목록

---
## Main
### `AutoLotto.class`
- [x] InputView, OutputView, Lottos 객체를 사용하여 입력값에 따른 로또 생성 및 출력을 담당
  - [x] 이때 무엇을 입력하고 어떤 로또를 생성하고, 어떤 내용을 출력할지는 각 객체에게 위임
 
## Model
### `Lottos.java`
- [x] 구매한 chances만큼 로또를 생성
  - [x] 이때 주어진 로또 생성 전략 패턴에 따라 로또를 생성 

### `LottoGenerator`
- [x] 1~45번까지 저장된 디폴트 로또를 생성
- [x] `Lottos`에서 주입된 로또 생성 전략 패턴에 따라 디폴트 로또를 변환하여 반환

### `LottoGeneratorStrategy`
- [x] 전략 패턴으로 로또의 번호 생성 인터페이스

### `RandomLottoGeneratorStrategy`
- [x] 랜덤으로 로또의 번호를 생성하는 전략 클래스

## View
### `InputView.java`
- [x] 로또 구매의 입력값을 받음
  - [x] 숫자 이외의 입력값을 막는 방어 로직 적용
  - [x] 1,000 단위의 구매값이 맞는지 체크하는 방어 로직 적용

### `OutputView.java`
- [x] 구매한 로또 개수를 출력
- [x] 구매한 자동로또를 모두 출력

### 컨벤션

- [x] Java : Intellij idea Code Style java 적용
- [x] Commit : AngularJS Commit Message 사용

### 코드 규칙
- [x] else 예약어 사용 X
- [x] indent의 들여쓰기 depth는 1회까지 허용
- [x] 함수(또는 메서드)의 길이가 15라인을 넘지 않도록 작성
- [x] 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현