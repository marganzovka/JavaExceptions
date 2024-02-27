import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Data {
    public String surname;
    public String name;
    public String patronymic;
    public Calendar dateBirth;
    public Long phoneNumber;
    public String gender;

    public Data(List<String> listData) {
        this.surname = listData.get(0).trim();
        this.name = listData.get(1).trim();
        this.patronymic = listData.get(2).trim();

        try {

            String birth = listData.get(3);
            List<String> listBirthStr = List.of(birth.trim().split("\\."));
            List<Integer> listBirth = new ArrayList<>();
            if (listBirthStr.size() != 3){
                throw new RuntimeException("Enter your date of birth in the format ##.##.####");
            }
            for (int i = 0; i < listBirthStr.size(); i++) {
                listBirth.add(Integer.parseInt(listBirthStr.get(i)));
            }
            if (listBirth.get(0).toString().length() > 2
                    || listBirth.get(1).toString().length() > 2
                    || listBirth.get(2).toString().length() != 4) {
                throw new RuntimeException("Enter your date of birth in the format ##.##.####");
            }
            this.dateBirth = new GregorianCalendar(listBirth.get(2), listBirth.get(1), listBirth.get(0));

            this.phoneNumber = Long.parseLong(listData.get(4).trim());
            this.gender = listData.get(5).trim();
            if (!this.gender.equals("f") && !this.gender.equals("m") || this.gender.length() > 1) {
                throw new RuntimeException("Enter your gender: 'f' or 'm'");
            }
            }catch (Exception e){
                throw new RuntimeException("Incorrect phone format. Please enter an integer value without spaces");
            }

    }
}
