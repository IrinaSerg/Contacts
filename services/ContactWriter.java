

public class ContactWriter {
    String basePath = "C:\\users\\Irina\\Desktop\\Contacts\\SavedContacts"
    private File baseDir;

    public ContactWriter() {
        if !(Files.exists(basePath)) {
            this.baseDir = new File(baseDir).mkdirs();
        }
    }

    public saveContact(Contact contact) {
        File file = new File(basePath + "\\" + contact.lastName + ".txt");
        if !(Files.exists(file)) {
            file.createNewFile();
        }

        FileWriter writer = new FileWriter(file, true);

        writer.write(contact.deserizalize() + "\n");
    }
}