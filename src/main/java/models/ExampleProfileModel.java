package models;

public class ExampleProfileModel {

    public int age;
    public String name;
    public String game;
    public String language;

    public ExampleProfileModel(int age, String name, String game, String language) {
        this.age = age;
        this.name = name;
        this.game = game;
        this.language = language;

        if (age <= 30) {
            this.age = 30;
        } else {
            this.age = age;
        }
    }

    @Override
    public String toString() {
        return "ExampleProfileModel{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", game='" + game + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
