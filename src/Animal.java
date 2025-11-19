public abstract class Animal {

    // 최대 100, 최소 0
    private int hungryStat;
    // 최대 100, 최소 0
    private int happinessStat;
    private String name;
    private int age;
    private String species;

    public Animal() {
    }

    public Animal(String name, int age) {
        this(100, 0, name, age);
    }

    public Animal(int hungryStat, int happinessStat, String name, int age) {
        this.hungryStat = hungryStat;
        this.happinessStat = happinessStat;
        this.name = name;
        this.age = age;
        this.species = "animal";
    }

    public void feed() {
        System.out.println(name + "에게 먹이를 줍니다.");
        hungryStat--;
        hungryStat = Math.max(hungryStat, 0);
    }

    public void play() {
        System.out.println(name + "과 놀아줍니다.");
        happinessStat++;
        happinessStat = Math.min(100, happinessStat);
    }

    public void sound() {
        System.out.println(name + "이 소리를 냅니다.");
    }

    public int getHungryStat() {
        return hungryStat;
    }

    public void setHungryStat(int hungryStat) {
        this.hungryStat = hungryStat;
    }

    public int getHappinessStat() {
        return happinessStat;
    }

    public void setHappinessStat(int happinessStat) {
        this.happinessStat = happinessStat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "hungryStat=" + hungryStat +
                ", happinessStat=" + happinessStat +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", species='" + species + '\'' +
                '}';
    }
}
