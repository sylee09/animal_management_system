public abstract class Animal {

    // 최대 100, 최소 0
    private int hungryStat;
    // 최대 100, 최소 0
    private int happinessStat;
    private String name;
    private int age;
    private String species;
    private Food favoriteFood;

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

    public abstract void feed(ZooKeeper zooKeeper, Food food);

    public abstract void play(ZooKeeper zooKeeper);

    public abstract void sound();

    public abstract String specialAbilityName();

    public abstract void performSpecialAbility();

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

    public Food getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(Food favoriteFood) {
        this.favoriteFood = favoriteFood;
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
