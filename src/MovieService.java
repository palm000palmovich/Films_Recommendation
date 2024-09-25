import java.time.Year;
import java.util.List;

public class MovieService {
    //проверка года выпуска на корректность
    public void checkYear(int year) throws IncorrectYearOfMovie {
        int currentYear = Year.now().getValue();
        if (year < 0 || year > currentYear){
            throw new IncorrectYearOfMovie("Недопустимое значение года выпуска!");
        }
    }


}
