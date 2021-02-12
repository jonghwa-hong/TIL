# Git 기초

### 참조

---

[Git - Git 저장소 만들기](https://git-scm.com/book/ko/v2/Git%EC%9D%98-%EA%B8%B0%EC%B4%88-Git-%EC%A0%80%EC%9E%A5%EC%86%8C-%EB%A7%8C%EB%93%A4%EA%B8%B0)

# 📌학습목표

- **Git 저장소 만들기**
- **수정하고 저장소에 저장하기**
- **파일 상태 확인하기**
- **파일 추적하기**
- **Modified 상태의 파일을 Stage 하기**
- **파일 무시하기**
- **Staged와 Unstaged 상태의 변경 내용을 보기**
- **변경사항 커밋하기**
- **Staging Area 생략하기**
- **파일 삭제하기**
- **파일 이름 변경하기**

---

## 🌟Git 저장소 만들기

---

Git repo를 쓰는 방법은 주로 두가지로 시작한다.

- 아직 버전관리를 하지 않는 로컬 디렉토리 하나를 선택해서 Git repo를 적용하는 방법
- 다른 어딘가에서 Git repo를 `Clone` 하는 방법

### 기존 디렉토리를 git repo로 만드는 법

- `cd 프로젝트위치`
- `git init` : `.git` 이라는 하위 디렉토리를 만든다. `.git` 디렉토리에는 뼈대만 들어있고 이 명령어만으로는 어떤 파일도 관리하지 않는다.

git이 파일을 관리하게 하려면 저장소에 파일을 추가하고 커밋해야 한다. `git add` 명령으로 파일을 추가하고 `git commit` 명령으로 커밋한다. 

⇒ 이 명령어들로 git repo를 만들고 파일 버전 관리를 시작가능하다.

### 기존 저장소를 Clone 하기

다른 프로젝트에 참여하려거나 Git 저장소를 복사하고 싶을 때 `git clone` 명령을 사용한다. `git clone` 을 실행하면 프로젝트 히스토리를 전부 받아온다. 

- `git clone <url>` : 저장소의 모든 데이터를 가져와 자동으로 최신 버전을 checkout 해 놓는다.

## 🌟Git의 기초 수정하고 저장소에 저장하기

---

만질 수 있는 Git 저장소를 하나 만들었고 워킹 디렉토리에 `Checkout` 도 했다. 이제는 파일을 수정하고 파일의 스냅샷을 커밋해 보자. 파일을 수정하다가 저장하고 싶으면 스냅샷을 커밋한다.

워킹 디렉토리의 모든 파일은 크게 Tracked(관리대상임)와 Untracked(관리대상이 아님)로 나눈다. Tracked 파일은 이미 스냅샷에 포함돼 있던 파일이다. 

- 워킹 디렉토리 → Tracked, Untracked, Stagging Area 상태 중 하나이다.

## 🌟파일의 상태 확인하기

---

파일의 상태를 확인하려면 보통 `git status` 명령을 사용한다. Clone 한 후에 바로 이 명령을 실행하면 아래과 같은 메시지를 볼 수 있다.

```bash
git status
On branch master
Your branch is up-to-date with 'origin/master'.
nothing to commit, working directory clean
```

위의 내용은 파일을 하나도 수정하지 않았다는 것을 말해준다. **기본 브랜치가 master이기 때문에 현재 브랜치 이름이 'master'로 나온다.** 

- **Tracked** 파일은 하나도 수정되지 않았다는 의미다.
- **Untracked** 파일은 아직 없어서 목록에 나타나지 않는다. 그리고 현재 작업 중인 브랜치를 알려주면서 서버의 같은 브랜치로부터 진행된 작업이 없는 것을 나타낸다.

프로젝트에 README 파일을 만들어보자. README 파일은 새로 만든 파일이기 때문에 `git status` 를 실행하면 'Untracked files'에 들어 있다.

```bash
$ echo 'My Project' > README
$ git status
On branch master
Your branch is up-to-date with 'origin/master'.
Untracked files:
  (use "git add <file>..." to include in what will be committed)

    README

nothing added to commit but untracked files present (use "git add" to track)
```

README 파일은 "Untracked files" 부분에 속해 있는데 이것은 README 파일이 Untracked 상태라는 것을 말한다. Git은 Untracked 파일을 아직 스냅샷(커밋)에 넣어지지 않은 파일이라고 본다. 파일이 Tracked 상태가 되기 전까지는 Git은 절대 그 파일을 커밋하지 않는다. 그럼 이런 README 파일을 추가해서 직접 Tracked 상태로 만들어 보자.

## 🌟파일 새로 추적하기

---

`git add` 명령으로 파일을 새로 추적할 수 있다. 아래 명령을 실행하면 Git은 README 파일을 추적한다.

```bash
git add README
```

`git status` 명령을 다시 실행하면 README 파일이 Tracked 상태이면서 커밋에 추가될 Staged 상태라는 것을 확인할 수 있다.

```bash
$ git status
On branch master
Your branch is up-to-date with 'origin/master'.
Changes to be committed:
  (use "git reset HEAD <file>..." to unstage)

    new file:   README
```

"**Changes to be commited**"에 들어 있는 파일은 Staged 상태라는 것을 의미한다. 커밋하면 `git add` 를 실행한 시점의 파일이 커밋되어 저장소 히스토리에 남는다. 앞에서 `git init` 명령을 실행한 후, `git add(files)` 명령을 실행했던 걸 기억할 것이다. 이 명령을 통해 디렉토리에 있는 파일을 추적하고 관리하도록 한다. `git add` 명령은 파일 또는 디렉토리의 경로를 아규먼트로 받는다. 디렉토리면 아래에 있는 모든 파일들까지 재귀적으로 추가한다. 

## **🌟Modified 상태의 파일을 Stage하기**

---

이미 Tracked 상태인 파일을 수정하는 법을 알아보자. CONTRIBUTING.md라는 파일을 수정하고 나서 `git status` 명령을 다시 실행하면 결과는 아래와 같다.

```bash
$ git status
On branch master
Your branch is up-to-date with 'origin/master'.
Changes to be committed:
  (use "git reset HEAD <file>..." to unstage)

    new file:   README

Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git checkout -- <file>..." to discard changes in working directory)

    modified:   CONTRIBUTING.md
```

"Changes not staged for commit"에 들어 있는 파일은 Tracked상태이지만 아직 Staged 상태는 아니라는 것이다. 이를 Staged 상태로 만들려면 `git add` 명령을 실행해야한다.

```bash
$ git add CONTRIBUTING.md
$ git status
On branch master
Your branch is up-to-date with 'origin/master'.
Changes to be committed:
  (use "git reset HEAD <file>..." to unstage)

    new file:   README
    modified:   CONTRIBUTING.md
```

두 파일 모두 staged 상태이므로 다음 커밋에 포함된다. **하지만** 아직 더 수정해야 한다는 것을 알게 되어 바로 커밋하지 못하는 상황이라면??? → 이 때는 [CONTRIBUTING.md](http://contributing.md) 파일을 열고 수정한다. 이제 커밋할 준비가 다 됐다고 생각하지만, git은 그렇지 않다. `git status` 명령으로 파일의 상태를 다시 확인해보자.

```bash
$ vim CONTRIBUTING.md
$ git status
On branch master
Your branch is up-to-date with 'origin/master'.
Changes to be committed:
  (use "git reset HEAD <file>..." to unstage)

    new file:   README
    modified:   CONTRIBUTING.md

Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git checkout -- <file>..." to discard changes in working directory)

    modified:   CONTRIBUTING.md
```

[CONTRIBUTING.md](http://contributing.md) 가 staged 상태이면서 동시에 unstaged 상태로 나온다. 즉, `git add` 명령을 실행한 후에 또 파일을 수정하면 `git add` 명령을 다시 실행해서 최신 버전을 staged 상태로 만들어야 한다.

```bash
$ git add CONTRIBUTING.md
$ git status
On branch master
Your branch is up-to-date with 'origin/master'.
Changes to be committed:
  (use "git reset HEAD <file>..." to unstage)

    new file:   README
    modified:   CONTRIBUTING.md
```

## **🌟 파일무시하기**

---

어떤 파일은 Git이 관리할 필요가 없다. 보통 로그 파일이나 빌드 시스템이 자동으로 생성한 파일이 그렇다. 그런 파일을 무시하려면 `.gitignore` 파일을 만들고 그 안에 무시할 파일 패턴을 적는다.

```bash
$ cat .gitignore
*.[oa]
*~
```

첫번째 라인은 확장자가 “.o” 나 “.a” 인 파일을 Git이 무시하라는 것이고 둘째 라인은 ~ 로 끝나는 모든 파일을 무시하라는 것이다. 보통 대부분의 텍스트 편집기에서 임시파일로 사용하는 파일 이름이기 때문이다. **“.o” 와 “.a” 는 각각 빌드 시스템이 만들어내는 오브젝트와 아카이브 파일이고 ~ 로 끝나는 파일은 Emacs나 VI 같은 텍스트 편집기가 임시로 만들어내는 파일이다.** **또 log, tmp, pid 같은 디렉토리나, 자동으로 생성하는 문서 같은 것들도 추가할 수 있다.** `.gitignore` 파일은 보통 처음에 만들어 두는 것이 편리하다. **그래서 Git 저장소에 커밋하고 싶지 않은 파일을 실수로 커밋하는 일을 방지할 수 있다.**

```bash
# 확장자가 .a인 파일 무시
*.a

# 윗 라인에서 확장자가 .a인 파일은 무시하게 했지만 lib.a는 무시하지 않음
!lib.a

# 현재 디렉토리에 있는 TODO파일은 무시하고 subdir/TODO처럼 하위디렉토리에 있는 파일은 무시하지 않음
/TODO

# build/ 디렉토리에 있는 모든 파일은 무시
build/

# doc/notes.txt 파일은 무시하고 doc/server/arch.txt 파일은 무시하지 않음
doc/*.txt

# doc 디렉토리 아래의 모든 .pdf 파일을 무시
doc/**/*.pdf
```

## 🌟 **Staged와 Unstaged 상태의 변경 내용을 보기**

---

단순히 파일이 변경 됐다는 사실이 아니라 어떤 내용이 변경됐는지 살펴보려면 `git status` 명령이 아니라 `git diff` 명령을 사용해야 한다. 보통 우리는 수정했지만, 아직 Staged 파일이 아닌 것?과 어떤 파일이 Staged 상태인지?가 궁금하기 때문에 `git status` 명령으로도 충분하다. `git diff` 명령을 사용하는데 Patch처럼 어떤 라인을 추가했고 삭제했는지가 궁금할 때 사용한다. `git diff` 는 나중에 더 자세히 다룬다.

README 파일을 수정해서 Staged 상태로 만들고 [CONTRIBUTING.md](http://contributing.md) 파일은 그냥 수정만 해둔다. 이 상태에서 `git status` 명령을 실행하면 아래와 같은 메시지를 볼 수 있다.

```bash
$ git status
On branch master
Your branch is up-to-date with 'origin/master'.
Changes to be committed:
  (use "git reset HEAD <file>..." to unstage)

    modified:   README

Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git checkout -- <file>..." to discard changes in working directory)

    modified:   CONTRIBUTING.md
```

`git diff` **명령을 실행하면 수정했지만 아직 staged 상태가 아닌 파일을 비교해 볼 수 있다.**

```bash
$ git diff
diff --git a/CONTRIBUTING.md b/CONTRIBUTING.md
index 8ebb991..643e24f 100644
--- a/CONTRIBUTING.md
+++ b/CONTRIBUTING.md
@@ -65,7 +65,8 @@ branch directly, things can get messy.
 Please include a nice description of your changes when you submit your PR;
 if we have to read the whole diff to figure out why you're contributing
 in the first place, you're less likely to get feedback and have your change
-merged in.
+merged in. Also, split your changes into comprehensive chunks if your patch is
+longer than a dozen lines.

 If you are starting to work on a particular area, feel free to submit a PR
 that highlights your work in progress (and note in the PR title that it's
```

**이 명령은 워킹 디렉토리에 있는 것과 Staging Area에 있는 것을 비교한다. 그래서 수정하고 아직 stage 하지 않은 것을 보여준다.**

만약 커밋하려고 staging area에 넣은 파일의 변경 부분을 보고 싶으면 `git diff --staged` 옵션을 사용한다. **이 명령은 저장소에 커밋한 것과 staging area에 있는 것을 비교한다.**

```bash
$ git diff --staged
diff --git a/README b/README
new file mode 100644
index 0000000..03902a1
--- /dev/null
+++ b/README
@@ -0,0 +1 @@
+My Project
```

!!! 꼭 잊지 말아야 할 것이 있는데 `git diff` 명령은 마지막으로 커밋한 후에 수정한 것들 전부를 보여주지 않는다.  `**git diff` 는 Unstaged 상태인 것들만 보여준다. 수정한 파일을 모두 Staging area에 넣었다면 `git diff` 명령은 아무것도 출력하지 않는다.**

[CONTRIBUTING.md](http://contributing.md) 파일을 staging 한 후에 다시 수정해도 `git diff` 명령을 사용할 수 있다. 이 때는 Staged 상태인 것과 Unstaged 상태인 것을 비교한다.

```bash
$ git add CONTRIBUTING.md
$ echo '# test line' >> CONTRIBUTING.md
$ git status
On branch master
Your branch is up-to-date with 'origin/master'.
Changes to be committed:
  (use "git reset HEAD <file>..." to unstage)

    modified:   CONTRIBUTING.md

Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git checkout -- <file>..." to discard changes in working directory)

    modified:   CONTRIBUTING.md
```

`git diff` 명령으로 Unstaged 상태인 변경 부분을 확인할 수 있다.

```bash
$ git diff
diff --git a/CONTRIBUTING.md b/CONTRIBUTING.md
index 643e24f..87f08c8 100644
--- a/CONTRIBUTING.md
+++ b/CONTRIBUTING.md
@@ -119,3 +119,4 @@ at the
 ## Starter Projects

 See our [projects list](https://github.com/libgit2/libgit2/blob/development/PROJECTS.md).
+# test line
```

Staged 상태인 파일은 `git diff --cached` 옵션으로 확인한다. `--staged` 와 `--cached` 는 같은 옵션이다.

```bash
$ git diff --cached
diff --git a/CONTRIBUTING.md b/CONTRIBUTING.md
index 8ebb991..643e24f 100644
--- a/CONTRIBUTING.md
+++ b/CONTRIBUTING.md
@@ -65,7 +65,8 @@ branch directly, things can get messy.
 Please include a nice description of your changes when you submit your PR;
 if we have to read the whole diff to figure out why you're contributing
 in the first place, you're less likely to get feedback and have your change
-merged in.
+merged in. Also, split your changes into comprehensive chunks if your patch is
+longer than a dozen lines.

 If you are starting to work on a particular area, feel free to submit a PR
 that highlights your work in progress (and note in the PR title that it's
```

## 🌟 변경사항 커밋하기

---

수정한 것을 커밋하기 위해 Staging area에 파일을 정리했다. Unstaged 상태의 파일은 커밋되지 않는 것을 기어해야 한다. 

```bash
$ git commit -m "Story 182: Fix benchmarks for speed"
[master 463dc4f] Story 182: Fix benchmarks for speed
 2 files changed, 2 insertions(+)
 create mode 100644 README
```

`commit` 명령은 몇 가지 정보를 출력하는데 위 예제는 (`master`) 브랜치에 커밋했고 체크섬은 (`463dc4f`)이라고 알려준다. 그리고 수정한 파일이 몇 개이고 삭제됐거나 추가된 라인이 몇 라인인지 알려준다.

---

## 🌟 Staging Area 생략하기

---

Staging Area는 커밋할 파일을 정리한다는 점에서 매우 유용하지만 복잡하기만 하고 필요하지 않은 때도 있다. 아주 쉽게 Staging Area를 생략할 수 있다. `git commit` 명령을 실행할 때 `-a` 옵션을 추가하면 Tracked 상태의 파일을 자동으로 Staging Area에 넣는다. 그래서 `git add` 명령을 실행하는 수고를 덜 수 있다.

```bash
$ git status
On branch master
Your branch is up-to-date with 'origin/master'.
Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git checkout -- <file>..." to discard changes in working directory)

    modified:   CONTRIBUTING.md

no changes added to commit (use "git add" and/or "git commit -a")
$ git commit -a -m 'added new benchmarks'
[master 83e38c7] added new benchmarks
 1 file changed, 5 insertions(+), 0 deletions(-)
```

## 🌟 파일 삭제하기

---

git에서 파일을 제거하려면 `git rm` 명령으로 Tracked 상태의 파일을 삭제한 후에(정확하게는 Staging Area에서 삭제하는 것) 커밋해야 한다. **이 명령은 워킹 디렉토리에 있는 파일도 삭제하기 때문에 실제로 파일도 지워진다.**

git 명령을 사용하지 않고 단순히 워킹 디렉토리에서 파일을 삭제하고 `git status` 명령으로 상태를 확인하면 git은 현재 "Changes not staged for commit" (즉, **Unstaged** 상태)라고 표시해준다.

```bash
$ rm PROJECTS.md
$ git status
On branch master
Your branch is up-to-date with 'origin/master'.
Changes not staged for commit:
  (use "git add/rm <file>..." to update what will be committed)
  (use "git checkout -- <file>..." to discard changes in working directory)

        deleted:    PROJECTS.md

no changes added to commit (use "git add" and/or "git commit -a")
```

그리고 `git rm` 명령을 실행하면 삭제한 파일은 staged 상태가 된다.

```bash
$ git rm PROJECTS.md
rm 'PROJECTS.md'
$ git status
On branch master
Your branch is up-to-date with 'origin/master'.
Changes to be committed:
  (use "git reset HEAD <file>..." to unstage)

    deleted:    PROJECTS.md
```

커밋하면 파일은 삭제되고 git은 파일을 더는 추적하지 않는다. 이미 파일을 수정했거나 staging area에 추가했다면 `-f` 옵션을 주어 강제로 삭제해야 한다. 이 점은 실수로 데이터를 삭제하지 못하도록 하는 안전장치다. 커밋 하지 않고 수정한 데이터는 git으로 복구할 수 없기 때문이다.

또 staging area에서만 제거하고 워킹 디렉토리에 있는 파일은 지우지 남겨둘 수 있다. 다시 말해서 하드디스크에 있는 파일은 그대로 두고 git만 추적하지 않게 한다. 이것은 `'gitignore` 파일에 추가하는 것을 빼먹었거나 대용량 로그 파일이나 컴파일된 파일인 `.a` 파일 같은 것을 실수로 추가했을 때 쓴다. `--cached` 옵션을 사용하여 명령을 실행한다.

```bash
$ git rm --cached README
```

여러 개의 파일이나 디렉토리를 한꺼번에 삭제할 수도 있다. 아래와 같이 `git rm` 명령에 file-glob 패턴을 사용한다.

```bash
$ git rm log/\*.log
```

`*` 앞에 `\` 을 사용한 것을 기억하자. 파일명 확장 기능은 쉘에만 있는 것이 아니라 Git 자체에도 있기 때문에 필요하다. 이 명령은 log/ 디렉토리에 있는 .log 파일을 모두 삭제한다. 아래의 예제처럼 할 수도 있다.

```bash
$ git rm \*~
```

이 명령은 `~` 로 끝나는 파일을 모두 삭제한다.

## 🌟 파일 이름 변경하기

---

git은 다른 vcs 시스템과는 달리 파일 이름의 변경이나 파일의 이동을 명시적으로 관리하지 않는다. 다시 말해서 파일 이름이 변경됐다는 별도의 정보를 저장하지 않는다. git은 똑똑해서 굳이 파일 이름이 변경됐다는 것을 추적하지 않아도 아는 방법이 있다.

아래와 같이 파일 이름을 변경할 수 있다.

```bash
git mv file_from file_to

$ git mv README.md README
$ git status
On branch master
Your branch is up-to-date with 'origin/master'.
Changes to be committed:
  (use "git reset HEAD <file>..." to unstage)

    renamed:    README.md -> README
```

사실 `git mv` 명령은 아래 명령어를 수행한 것과 완전 똑같다.

```bash
$ mv README.md README
$ git rm README.md
$ git add README
```

`git mv` 명령은 일종의 단축 명령어이다. 이 명령으로 파일 이름을 바꿔도 되고 `mv` 명령으로 파일 이름을 직접 바꿔도 된다. 단지 `git mv` 명령은 편리하게 명령을 세 번 실행해주는 것 뿐이다.