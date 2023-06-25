

public class Main {
    public static void main(String[] args) {
        ContactValidator validator = new ContactValidator();
        ContactWriter writer = new ContactWriter();
        Scanner inScanner = new Scanner(System.in);

        while(true) {
            System.out.println("Введите данные контакта в формате:");
            System.out.println("Фамилия Имя Отчетво Номер_Телефона Дата_Рождения(день.месяц.год) Пол(f/m)");

            String input = inScanner.nextLine();

            if input.toLowerCase() == "q" {
                break;
            }

            try {
                Contact contact = validator.validate(input);
                writer.saveContact(contact);
            } catch (IncorrectParamsException e) {
                System.out.println("Неверно указаны параметры или их последовательность!");
            }
        }
    }
}