# 🍣 Kim Sushi Plugin

**브롤스타즈의 김초밥과 와사비의 힘을 활용한 마인크래프트 야생 RPG 플러그인!**  
총 30종 이상의 김초밥 검과 다양한 와사비 파워로 색다른 전투 경험을 제공합니다.

---

## 📦 설치 방법

해당 플러그인을 사용하기 위해 아래 리소스가 필요합니다:

- 🧱 **ItemsAdder** (아이템/블럭 통합 리소스)  
  🔗 [ItemsAdder (Spigot 링크)](https://www.spigotmc.org/resources/%E2%9C%A8itemsadder%E2%AD%90emotes-mobs-items-armors-hud-gui-emojis-blocks-wings-hats-liquids.73355/)
- 🖼️ **GUI 리소스팩**: 본 프로젝트의 `김초밥 플러그인 GUI 리소스팩` 다운로드
- 📁 **콘텐츠 팩**: 본 프로젝트의 `sushi_pack` 다운로드

> 리소스 적용 후 서버를 재시작하거나 `/iazip` 명령어로 리소스 갱신하세요.

---

## ✅ 주요 기능

- 🏪 **김초밥 상점 GUI**
- ⚔️ **김초밥 강화 시스템** (업그레이드 가능)
- 🎁 **김초밥 오픈 기능** (무작위 김초밥 획득)
- 🗡️ **30종 이상의 김초밥 검**
- 🌶️ **다양한 와사비 파워** 효과 지원

---

## 🌶️ 와사비 파워 예시

| 파워 이름            | 설명                                 |
|---------------------|--------------------------------------|
| `wasabi_power`      | 일정 확률로 속도 및 저항 효과 부여             |
| `wasabi_explosion`  | 공격 시 폭발 효과 발생                         |
| `bittertears`       | 타격 시 실명 또는 불리한 상태 이상 유발           |
| `plenty_wasabi`     | 상대방이 음식 섭취 시 피해 발생                  |
| `infinite_sushi`    | 일정 확률로 김초밥 아이템 추가 지급              |
| ...                 | 추가 예정 파워 다수 있음                         |

---

## 🚧 개발 예정 기능

- 🔧 **김초밥 검 업그레이드 전체 단계** 구현 중
- 📖 **김초밥 도감 GUI** (모든 김초밥과 효과를 정리한 백과사전 기능)

---

## 🧱 플러그인 구조 예시

src/
└─ main/
└─ java/
└─ org/
└─ sushi/
├─ Main.java
├─ commands/
├─ SushiSkills/
├─ sushiitems/
└─ ...

yaml
복사
편집

---

## ⚙️ 사용 정보

- 💡 서버 버전: `Paper 1.20.x` (Spigot/Purpur 호환)
- 🧩 필수 플러그인: ItemsAdder
- 🛠️ 빌드 도구: Gradle / Maven (선택)

---

## 📜 라이선스

이 플러그인은 [MIT 라이선스](LICENSE)를 따릅니다.