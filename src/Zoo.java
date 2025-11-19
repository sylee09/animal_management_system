import java.util.ArrayList;
import java.util.HashMap;

public class Zoo {
    private ArrayList<Animal> animals = new ArrayList<>();
    private ArrayList<ZooKeeper> zooKeepers = new ArrayList<>();
    private ZooKeeper curZooKeeper;

    public Zoo() {
        zooKeepers.add(new ZooKeeper("No Speciality"));
        zooKeepers.add(new ZooKeeper("Bird"));
        zooKeepers.add(new ZooKeeper("Mammal"));
        zooKeepers.add(new ZooKeeper("Reptile"));
        curZooKeeper = zooKeepers.get(0);
    }

    public Animal registerAnimal(int option, String name, int age) {
        Animal animal = null;
        if (option == 1) {
            animal = new Dog(name, age);
        } else if (option == 2) {
            animal = new Cat(name, age);
        } else if (option == 3) {
            animal = new Eagle(name, age);
        } else if (option == 4) {
            animal = new Penguin(name, age);
        } else if (option == 5) {
            animal = new Lion(name, age);
        } else if (option == 6) {
            animal = new Elephant(name, age);
        } else if (option == 7) {
            animal = new Snake(name, age);
        } else if (option == 8) {
            animal = new Turtle(name, age);
        }
        animals.add(animal);
        return animal;
    }

    public void printAnimalList() {
        for (int idx = 1; idx <= animals.size(); idx++) {
            System.out.println(idx + ". " + animals.get(idx - 1).getName() + "(" + animals.get(idx - 1).getSpecies() + ", "
                    + animals.get(idx - 1).getAge() + "살)");
        }
    }

    public void printAnimalAbilityList() {
        for (int idx = 1; idx <= animals.size(); idx++) {
            System.out.println(idx + ". " + animals.get(idx - 1).getName() + "(" + animals.get(idx - 1).getSpecies() + " - "
                    + animals.get(idx - 1).specialAbilityName() + "능력)");
        }
    }

    public void performSpecialAbility(int idx) {
        animals.get(idx).performSpecialAbility();
    }

    public void playWithAnimal(int idx) {
        animals.get(idx).play(curZooKeeper);
    }

    public void feedAnimal(int idx, Food food) {
        animals.get(idx).feed(curZooKeeper, food);
    }

    public void printAnimalStatus() {
        for (Animal animal : animals) {
            System.out.print(animal);
        }
    }

    public void printAnimalSound(int idx) {
        animals.get(idx).sound();
    }

    public int getAnimalSize() {
        return animals.size();
    }

    public ZooKeeper getCurZooKeeper() {
        return curZooKeeper;
    }

    public void setCurZooKeeper(int idx) {
        this.curZooKeeper = zooKeepers.get(idx);
    }

    public ArrayList<ZooKeeper> getZooKeepers() {
        return zooKeepers;
    }

    public void printStatisticsInfo() {
        if (animals.isEmpty()) {
            System.out.println("현재 동물원에 동물이 없습니다.");
            return;
        }
        HashMap<String, Integer> map = new HashMap<>();
        int totalAnimalCount = animals.size();
        double avgHappiness = 0;
        Animal happiestAnimal = null;
        int topHappyPoint = Integer.MIN_VALUE;

        ArrayList<Animal> hungryAnimals = new ArrayList<>();
        for (Animal animal : animals) {
            map.put(animal.getSpecies(), map.getOrDefault(animal.getSpecies(), 0) + 1);
            avgHappiness += animal.getHappinessStat();
            if (animal.getHungryStat() > 50) {
                hungryAnimals.add(animal);
            }
            if (animal.getHappinessStat() > topHappyPoint) {
                topHappyPoint = animal.getHappinessStat();
                happiestAnimal = animal;
            }
        }
        avgHappiness /= totalAnimalCount;

        System.out.println("=== 동물원 통계 ===");
        System.out.println("- 전체 동물 수: " + totalAnimalCount);
        System.out.println("- 평균 행복도: " + avgHappiness);
        StringBuilder sb = new StringBuilder();
        sb.append("- 배고픈 동물: ");
        for (Animal animal : hungryAnimals) {
            sb.append(animal.getSpecies() + "(" + animal.getName() + "), ");
        }
        sb.delete(sb.length() - 2, sb.length());
        System.out.println(sb.toString());
        sb = new StringBuilder();
        sb.append("- 가장 행복한 동물: " + happiestAnimal.getSpecies() + "(" + happiestAnimal.getName() + ") " + "- 행복도 "
                + happiestAnimal.getHappinessStat());
        System.out.println(sb.toString());
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }
}
