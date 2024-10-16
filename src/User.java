import java.util.ArrayList;
import java.util.List;

public class User {
    private int age;
    private Movie bestFilms;
    private Movie watchLater;


    //Конструктор
    public User(int age, Movie bestFilms, Movie watchLater) {
        this.age = age;
        this.bestFilms = bestFilms;
        this.watchLater = watchLater;
    }

    //Геттеры и сеттеры


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Movie getBestFilms() {
        return bestFilms;
    }

    public void setBestFilms(Movie bestFilms) {
        this.bestFilms = bestFilms;
    }

    public Movie getWatchLater() {
        return watchLater;
    }

    public void setWatchLater(Movie watchLater) {
        this.watchLater = watchLater;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", bestFilms=" + bestFilms +
                ", watchLater=" + watchLater +
                '}';
    }
}
