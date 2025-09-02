package models;

public class ValidProfileModel {


    private int age;
    private String name;
    private String game;
    private String language;

    public int getAge() {
        return age;
    }

    public void setAge(int userAge) {
        this.age = userAge;
    }

    public String getName() {
        return name;
    }

    public void setName(String userName) {
        if(userName.isEmpty()){
            System.out.println("Ты ввел пустое имя");
        }else {
            name = userName;
        }
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "ValidProfileModel{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", game='" + game + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
