import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MovieService ser = new MovieService();

        //Структура фильмов
        List<Movie> allMovies = new ArrayList<>();

        Movie mov1 = new Movie("Ричард Фейнман", "Боевик", 2004);
        allMovies.add(mov1);
        Movie mov2 = new Movie("Гай Ричи", "Комедия", 1998);
        allMovies.add(mov2);
        Movie mov3 = new Movie("Кристофер Нолан", "Научная фантастика", 2010);
        allMovies.add(mov3);
        Movie mov4 = new Movie("Квентин Тарантино", "Драма", 1994);
        allMovies.add(mov4);
        Movie mov5 = new Movie("Стэнли Кубрик", "Ужасы", 1980);
        allMovies.add(mov5);
        Movie mov6 = new Movie("Питер Джексон", "Фэнтези", 2001);
        allMovies.add(mov6);
        Movie mov7 = new Movie("София Коппола", "Комедия", 2003);
        allMovies.add(mov7);
        Movie mov8 = new Movie("Гильермо дель Торо", "Фэнтези", 2006);
        allMovies.add(mov8);
        Movie mov9 = new Movie("Джеймс Кэмерон", "Экшен", 1997);
        allMovies.add(mov9);
        Movie mov10 = new Movie("Тим Бертон", "Мультфильм", 1993);
        allMovies.add(mov10);

        //Проверка корректности ввода года выпуска фильмов
        for (int i = 0; i < allMovies.size(); i++){
                ser.checkYear(allMovies.get(i).getYear());

        }

        //Структура пользователей
        List<User> allUsers = List.of(
             new User(24, allMovies.get(0), allMovies.get(1)),
             new User(17, allMovies.get(3), allMovies.get(0)),
                new User(22, allMovies.get(1), allMovies.get(5)),
                new User(30, allMovies.get(2), allMovies.get(7)),
                new User(25, allMovies.get(4), allMovies.get(1)),
                new User(18, allMovies.get(0), allMovies.get(3)),
                new User(27, allMovies.get(6), allMovies.get(8)),
                new User(21, allMovies.get(5), allMovies.get(2)),
                new User(35, allMovies.get(7), allMovies.get(4)),
                new User(29, allMovies.get(3), allMovies.get(6))
                );

        //Массив для счета тиража
        int[] edition = new int[allMovies.size()];
        //Система рекомендаций
        for (int i = 0; i < allUsers.size(); i++){
            List<Movie> recommendation = new ArrayList<>();
            for (int j = 0; j < allMovies.size(); j++){
                if (allMovies.get(j).getGenre() == allUsers.get(i).getBestFilms().getGenre() || //жанр имеющегося == жанр любимго
                        allMovies.get(j).getGenre() == allUsers.get(i).getWatchLater().getGenre() || //жанр имеющегося == жанр "посмотреть позже"
                        allMovies.get(j).equals(allUsers.get(i).getWatchLater())){ //имеющийся фильм == фильм "посмотреть позже"
                    recommendation.add(allMovies.get(j));
                    edition[j]+=1;
                }
            }
            System.out.println("У пользователя под номером " + (i+1) + " такие рекомендации: " +
            recommendation);
        }
        System.out.println(Arrays.toString(edition));

        System.out.println("\n");
        System.out.println("Рейтинг фильмов");
        for (int i = 0; i < edition.length; i++){
            String s = "";
            for (int j = 0; j < edition[i]; j++){
                s+="#";
            }

            System.out.println(allMovies.get(i) + ":  " + s);
        }

        System.out.println("\n\n\n");
        System.out.println("Гипотезы о кассовых сборах, если бы с каждого человека можно было собрать по 10 долларов:" + "\n");
        int sum = 10;
        for (int i = 0; i < allMovies.size(); i++){
            System.out.println(allMovies.get(i) + " " + (edition[i]*sum) + " долларов");
        }
        System.out.println("\n\n\n");

        //поиск фильма с наименьшим тиражем
        int minIndex = 0, minEdition = 100000;
        List<Movie> worstMovies = new ArrayList<>();
        for (int i = 0; i < edition.length; i++){
            if (edition[i] < minEdition){
                minIndex = i;
                minEdition = edition[i];
            }
        }
        System.out.println(minIndex);
        for (int i = 0; i < edition.length; i++){
            if (minIndex == i){
                worstMovies.add(allMovies.get(i));
            }

        }

        //Удаление самых провальных фильмов
        if (worstMovies.size() > 1){
            for (int i = 0; i < worstMovies.size(); i++){
                for (int j = 0; j < allMovies.size(); j++){
                    if (allMovies.get(j).equals(worstMovies.get(i))){
                        allMovies.remove(j);
                    }
                }
            }
        } else{
            allMovies.remove(minIndex);
        }
        System.out.println("Псоле удаления провальных фильмов осталось " + allMovies.size() + " фильмов \n");
        for (int i = 0; i < allMovies.size(); i++){
            System.out.println(allMovies.get(i) + "\n");
        }
    }
}