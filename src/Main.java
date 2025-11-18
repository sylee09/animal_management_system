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
        System.out.println("=== 동물원 관리 시스템 ===");
        System.out.println("1. 동물 등록");
        System.out.println("2. 동물 목록 보기");
        System.out.println("3. 동물과 놀기");
        System.out.println("4. 먹이주기");
        System.out.println("5. 동물 상태 확인");
        System.out.println("6. 울음소리 듣기");
        System.out.println("7. 종료");
        System.out.print("메뉴를 선택하세요: ");
        int op = -1;
        try {
            op = sc.nextInt();
            if (op < 1 || op > 7) {
                throw new OptionChooseException();
            }
        } catch (OptionChooseException e) {
            System.out.println("유효한 숫자를 입력해주세요 : 1~7번이 유효");
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
                    printAnimalStatus();
                    break;
                case 6:
                    printAnimalSound();
                    break;
                case 7:
                    flag = true;
                    break;
            }
        }
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
        System.out.print("동물 종류를 선택하세요 (1.강아지 2.고양이): ");
        int op = 0;
        try {
            op = sc.nextInt();
            if (op != 1 && op != 2) {
                throw new OptionChooseException();
            }
        } catch (OptionChooseException e) {
            System.out.println("유효한 숫자를 입력하세요 (1.강아지 2.고양이)");
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
        zoo.feedAnimal(idx);
    }

    private void printAnimalStatus() {
        zoo.printAnimalStatus();
    }

    private void printAnimalSound() {
        printAnimalList();
        System.out.print("울음소리를 듣고싶은 동물을 선택하세요: ");
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

    public static void main(String[] args) {
        Main main = new Main();
        main.startProgram();
    }
}