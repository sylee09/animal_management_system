import java.util.ArrayList;

public class Zoo {
    private ArrayList<Animal> animals = new ArrayList<>();

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
        animals.get(idx).play();
    }

    public void feedAnimal(int idx) {
        animals.get(idx).feed();
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
}
