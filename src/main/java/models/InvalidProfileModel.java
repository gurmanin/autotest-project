package models;

public class InvalidProfileModel {

    public int age;
    public String name;
    public String game;
    public String language;

    public InvalidProfileModel(int age, String name, String game, String language) {

        this.name = name;
        this.game = game;
        this.language = language;

        if(age<=30){
            System.out.println("Ошибка: Возраст должен быть не менее 30 лет");
        }else{
            this.age=age;

        }
    }

    @Override
    public String toString() {
        return "InvalidProfileModel{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", game='" + game + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
