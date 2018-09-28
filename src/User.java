public class User {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String gender;
    private int age;

    public User(String firstName, String lastName, String username, String password, String gender, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.age = age;
    }

    public String getPassword() {
        return password;
    }
}
