## TODO
-[x] 2등 보너스 추가 및 계산식을 수정한다.

## 피드백 후 변경 사항
### LottoResult 역할
[AS-IS] <br>
로또 일치하는 개수 계산을 가져와서 결과를 저장하기 위해  
보너스 여부와 일치하는 개수로 분기하여 결과 개수를 늘리며 결과 저장

[TO-BE] <br>
결과를 받아 +1

### LottoMachine 역할<br>
[AS-IS]<br>
금액 및 횟수만큼 로또를 생성해서 로또 리스트를 저장
[TO-BE]<br>
로또리스트 멤버 변수 삭제, 저장만 하여 로또 리스트 반환

### Lottos 추가
LottoMachine의 로또리스트 멤버변수를 제거하므로써 추가

### LottoRank
[AS-IS] enum LottoCalcular, enum WinPrice <br>
[TO-BE] enum LottoRank 로 통합 <br>
매칭수와 보너스 매치 여부를 가져와서 해당 로또 등수를 계산 및 반환 (추가)

### LottoService
[AS-IS] 로또 생성 / 로또 당첨번호로 계산 호출 / 마진 구하기 <br>
[TO-BE] 로또 생성 / 로또 매칭수와 보너스볼여부, 그에 따른 등수를 조회하고 결과업데이트 호출하는 계산 로직 / 마진 구하기

### LottoWinning
당첨번호 매칭 수 구하기 추가 

