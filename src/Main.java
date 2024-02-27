import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите следующие данные через проблел: 'Фамилия Имя Отчество дата_рождения номер_телефона пол'");
        String data = scanner.nextLine();
//        String data = "Фамилия Имя Отчество 12.12.2002 54654 f";

        saveData(data);
    }

    private static List<String> parseData(String data){
        List<String> dataLIst = new ArrayList<String>();
        dataLIst = List.of(data.trim().split(" "));
        if (dataLIst.size() != 6){
            throw new RuntimeException ("Invalid data. You have entered "+ dataLIst.size() +" data but need 6" );
        }
        return dataLIst;
    }

    private static void saveData(String dataLine){
        List<String> dataLIst = parseData(dataLine);
        Data data = new Data(dataLIst);
        File file = new File(data);
        file.writeToFile();
    }
}
