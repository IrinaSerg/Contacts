package models;

public class Contact {
    private String lastName;
    private String firstName;
    private String middleName;
    private UInteger phone;
    private Date birthDate;
    private String sex;
    private DateTimeFormatter dateFormatter;

    public Contact(String lastName, 
                   String firstName, 
                   String middleName,
                   UInteger phone,
                   Date birthDate,
                   String sex) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.phone = phone;
        this.birthDate = birthDate;
        this.sex = sex;
        this.dateFormatter = DateTimeFormatter.ofPattern("dd.mm.yyyy");
    }

    public String deserialize() {
        String formatedBirthDate = birthDate.format(dateFormatter);
        return String.format(
            "%s %s %s %d %s %s",
            lastName,
            firstName,
            middleName,
            phone,
            formatedBirthDate,
            sex
        );
    }
}