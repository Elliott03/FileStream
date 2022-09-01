import java.time.LocalDate;

public class Person {

    String firstName;

    String lastName;

    String id;

    String title;

    int yob;

    public Person(String firstName, String lastName, String id, String title, int yob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.title = title;
        this.yob = yob;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYob() {
        return yob;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }

    public String fullName() {
        return this.firstName + " " + this.lastName;
    }

    public String formalName() {
        return this.title + " " + fullName();
    }

    public String getAge() {
        int currentYear = LocalDate.now().getYear();
        return String.valueOf(currentYear - yob);
    }
    public String getAge(int year) {
        return String.valueOf(year - yob);
    }

    public String toCSVDataRecord() {
        return this.id + "," + this.firstName + "," + this.lastName + "," + this.title + "," + this.yob;
    }

}
