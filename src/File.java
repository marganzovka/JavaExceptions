import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class File {
    Data data;
    public File(Data data) {
        this.data = data;
    }

    public void writeToFile() {
        String filename = this.data.surname + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(this.data.surname + " " + this.data.name + " " + this.data.patronymic + " " + this.data.dateBirth.getTime() + " " + this.data.phoneNumber + " " + this.data.gender + "\n");
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
