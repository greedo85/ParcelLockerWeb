package parcellocker;

import lombok.ToString;

@ToString
public class Sender {

    private String name;
    private String surname;
    private String email;
    private long phonenumber;

    public Sender( String name, String surname, String email, long phonenumber ) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phonenumber = phonenumber;
    }
}
