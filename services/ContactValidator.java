
public class ContactValidator {
    public ContactValidator() {}

    public Contact validate(String input) throws IncorrectParamsException {
        String[] splited = input.split(" ");
        if splited.length != 6 {
            throw new IncorrectParamsException();
        }

        Scanner scanner = new Scanner(splited[3]);
        try {
            UInteger phone = scanner.nextInt();
        } catch (Exception e) {
            throw new IncorrectParamsException();
        }

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.mm.yyyy");
        try {
            Date birthDate = dateFormatter.parse(splited[4]);
        } catch (Exception e) {
            throw new IncorrectParamsException();
        }

        if splited[5] != "f" || splited[5] != "m" {
            throw new IncorrectParamsException();
        }

        Contact contact = new Contact(
            firstName: splited[0],
            lastName: splited[1],
            middleName: splited[2],
            phone: phone,
            birthDate: birthDate,
            sex: sex
        );

        return contact;
    }
}

public class IncorrectParamsException extends RuntimeException {}