import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private final Zoo zoo;
    private final Scanner sc;

    public Main() {
        zoo = new Zoo();
        sc = new Scanner(System.in);
    }


    private int printOption(Scanner sc) {
        System.out.println("=== 확장된 동물원 관리 시스템 ===");
        System.out.println("1. 동물 등록");
        System.out.println("2. 동물 목록 보기");
        System.out.println("3. 동물과 놀기");
        System.out.println("4. 먹이주기");
        System.out.println("5. 특별 능력 사용");
        System.out.println("6. 사육사 관리");
        System.out.println("7. 통계 보기");
        System.out.println("8. 종료");
        System.out.print("메뉴를 선택하세요: ");
        int op = -1;
        try {
            op = sc.nextInt();
            if (op < 1 || op > 8) {
                throw new OptionChooseException();
            }
        } catch (OptionChooseException e) {
            System.out.println("유효한 숫자를 입력해주세요 : 1~8번이 유효");
        } catch (RuntimeException e) {
            System.out.println("숫자를 입력하세요.");
        }finally {
            sc.nextLine();
        }
        return op;
    }

    private void startProgram() {
        boolean flag = false;
        while (!flag) {
            int op = printOption(sc);
            switch(op) {
                case 1:
                    registerAnimal();
                    break;
                case 2:
                    printAnimalList();
                    break;
                case 3:
                    playWithAnimal();
                    break;
                case 4:
                    feedAnimal();
                    break;
                case 5:
                    useSpecialAbility();
                    break;
                case 6:
                    manageZookeeper();
                    break;
                case 7:
                    flag = true;
                    break;
            }
        }
    }

    private void manageZookeeper() {
        for (int i = 1; i <= zoo.getZooKeepers().size(); i++) {
            System.out.println(i + "번 사육사: " + zoo.getZooKeepers().get(i - 1));
        }
        System.out.println("현재 사육사: " + zoo.getCurZooKeeper());
        System.out.print("바꿀 사육사 번호 입력: ");
        int op = -1;
        try {
            op = sc.nextInt() - 1;
            if (op < 0 || op >= zoo.getZooKeepers().size()) {
                throw new OptionChooseException();
            }
        } catch (OptionChooseException e) {
            System.out.println("유효한 숫자를 입력하세요");
            return;
        } catch (RuntimeException e) {
            System.out.println("숫자를 입력하세요.");
            return;
        }finally {
            sc.nextLine();
        }
        zoo.setCurZooKeeper(op);
    }

    private void registerAnimal() {
        System.out.print("동물 이름을 입력하세요: ");
        String name = sc.nextLine();
        System.out.print("동물 나이를 입력하세요: ");
        int age;
        try {
            age = sc.nextInt();
            if (age < 0) {
                throw new RuntimeException();
            }
        } catch (RuntimeException e) {
            System.out.println("유효한 숫자를 입력하세요.");
            return;
        }finally {
            sc.nextLine();
        }
        System.out.print("동물 종류를 선택하세요 (1.강아지 2.고양이 3.독수리 4.펭귄 5.사자 6.코끼리 7.뱀 8.거북이): ");
        int op = 0;
        try {
            op = sc.nextInt();
            if (!(op >= 1 && op <= 8)) {
                throw new OptionChooseException();
            }
        } catch (OptionChooseException e) {
            System.out.println("유효한 숫자를 입력하세요 (1.강아지 2.고양이 3.독수리 4.펭귄 5.사자 6.코끼리 7.뱀 8.거북이)");
            return;
        } catch (RuntimeException e) {
            System.out.println("숫자를 입력하세요.");
            return;
        }finally {
            sc.nextLine();
        }
        Animal animal = zoo.registerAnimal(op, name, age);
        System.out.println(animal.getName() + "(" + animal.getSpecies() + ", " + animal.getAge() + "살)가 등록되었습니다.");
    }

    private void printAnimalList() {
        zoo.printAnimalList();
    }

    private void playWithAnimal() {
        printAnimalList();
        System.out.print("놀아줄 동물을 선택하세요: ");
        int idx = -1;
        try {
            idx = sc.nextInt() - 1;
            if (idx >= zoo.getAnimalSize() || idx < 0) {
                throw new OptionChooseException();
            }
        } catch (OptionChooseException e) {
            System.out.println("유효한 숫자를 입력해주세요");
            return;
        } catch (RuntimeException e) {
            System.out.println("숫자를 입력하세요.");
            return;
        }finally {
            sc.nextLine();
        }
        zoo.playWithAnimal(idx);
    }

    private void feedAnimal() {
        printAnimalList();
        System.out.print("먹이줄 동물을 선택하세요: ");
        int idx=-1;
        try {
            idx = sc.nextInt() - 1;
            if (idx >= zoo.getAnimalSize() || idx < 0) {
                throw new OptionChooseException();
            }
        } catch (OptionChooseException e) {
            System.out.println("유효한 숫자를 입력해주세요");
            return;
        } catch (RuntimeException e) {
            System.out.println("숫자를 입력하세요.");
            return;
        }finally {
            sc.nextLine();
        }
        System.out.print("먹이를 선택하세요: ");
        Food food = null;
        String option;
        while (food == null) {
            System.out.print("줄수있는 먹이: ");
            for (Food f : Food.values()) {
                System.out.print(f.name() + " ");
            }
            option = sc.nextLine();
            option = option.toLowerCase();
            if (option.equals("meat")) {
                food = Food.MEAT;
            } else if (option.equals("fish")) {
                food = Food.MEAT;
            } else if (option.equals("nuts")) {
                food = Food.NUTS;
            } else if (option.equals("vegetable")) {
                food = Food.VEGETABLE;
            }
        }
        try {
            zoo.feedAnimal(idx, food);
        } catch (RuntimeException e) {
            System.out.println("동물이 선호하는 먹이가 아닙니다.");
        }

    }

    private void printAnimalStatus() {
        zoo.printAnimalStatus();
    }

    private void printAnimalSound() {
        System.out.println("울음소리를 듣고싶은 동물을 선택하세요: ");
        printAnimalList();
        int idx=-1;
        try {
            idx = sc.nextInt() - 1;
            if (idx >= zoo.getAnimalSize() || idx < 0) {
                throw new OptionChooseException();
            }
        } catch (OptionChooseException e) {
            System.out.println("유효한 숫자를 입력해주세요");
            return;
        } catch (RuntimeException e) {
            System.out.println("숫자를 입력하세요.");
            return;
        }finally {
            sc.nextLine();
        }
        zoo.printAnimalSound(idx);
    }

    private void printAnimalAbilityList() {
        zoo.printAnimalAbilityList();
    }

    private void useSpecialAbility() {
        System.out.println("특별 능력을 사용할 동물을 선택하세요: ");
        printAnimalAbilityList();
        int idx=-1;
        try {
            idx = sc.nextInt() - 1;
            if (idx >= zoo.getAnimalSize() || idx < 0) {
                throw new OptionChooseException();
            }
        } catch (OptionChooseException e) {
            System.out.println("유효한 숫자를 입력해주세요");
            return;
        } catch (RuntimeException e) {
            System.out.println("숫자를 입력하세요.");
            return;
        }finally {
            sc.nextLine();
        }
        zoo.performSpecialAbility(idx);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.startProgram();
    }
}