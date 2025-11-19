import java.util.ArrayList;

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
}
