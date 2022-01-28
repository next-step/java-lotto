# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 기능 요구 사항 

- [ ] 계산식을 입력받을 수 있다. - view#InputView#readFormula
- [ ] 빈 문자열 또는 `null` 값을 입력할 경우 0을 반환해야 한다. - util#validateInput#isEmptyOrNull
- [ ] 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다. - domain#Parser#getOneNumberToString
- [ ] 숫자 두개를 쉼표(`,`) 구분자로 입력 받을 수 있다. - domain#Parser#splitStringToNumber
- [ ] 구분자를 쉼표(`,`) 이외에 콜론(`:`)을 사용할 수 있다. - domain#Parser#
- [ ] 두 숫자의 합을 반환한다. - domain#StringCalculator#add
- [ ] `//`와 `\\n` 문자 사이에 커스텀 구분자를 지정할 수 있다. - domain#Parser#CustomSplit
  - 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- [ ] 문자열 계산기에 음수를 전달하는 경우 `RuntimeException` 예외 처리를 한다. - util#validateCalculator

## 마감 기한

금요일 18시

## multiple authors

```bash
git commit -m "commit message


Co-authored-by: hochan222 <hochan049@gmail.com>
Co-authored-by: YuYangWoo <yuyw0712@naver.com>
```
